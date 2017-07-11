package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.AbsenceDao;
import fr.simplon.dao.EmployeDao;
import fr.simplon.dao.EquipeDao;
import fr.simplon.dao.StatutDao;
import fr.simplon.domain.Absence;
import fr.simplon.domain.Employe;
import fr.simplon.domain.Equipe;
import fr.simplon.domain.dto.AbsenceDto;
import fr.simplon.exception.ServiceException;
import fr.simplon.services.utils.EmailService;
import fr.simplon.services.utils.MapperDto;


/**
 * Service de validation olu refus des absences
 * @author JGL
 *
 */
@Service
@Transactional
public class ValidationService {
	
	@Autowired
	private AbsenceDao absenceDao;
	
	@Autowired
	private EmployeDao employeDao;
	
	@Autowired
	private EquipeDao equipeDao;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private StatutDao statutDao;
	
	@Autowired
	MapperDto mapper;

	public List<AbsenceDto> listeValidation(String nomEquipe) throws SQLException{
		Equipe equipe = equipeDao.findEquipeByNom(nomEquipe);
		List<Employe> employeByEquipe;
		
		List<Absence> absence;
		List<Absence> absenceEquipe = new ArrayList<>();
		List<AbsenceDto> absenceDto;
		employeByEquipe = employeDao.findByEquipe(equipe);
		
		for (Employe employe : employeByEquipe) {
			absence=employe.getAbsence();
			absenceEquipe.addAll(absence);
			
		}
		
		absenceDto = mapper.convertListeAbsenceToDto(absenceEquipe);
		
		
		return absenceDto;
	}
	
	public AbsenceDto updateValidation(String numDemande, String valide) throws Exception{
		int validation = Integer.parseInt(valide);
		Absence absence = absenceDao.findByNumDemande(numDemande);
		AbsenceDto absenceDto;
		switch (validation){
		case  2 : 
			absence.setStatut(statutDao.findByCode(validation));
			emailService.sendEmail(absence, absence.getEmploye().getUser().getEmail(), "Validation de votre congé",3);
			emailService.sendEmail(absence, absence.getEmploye().getServiceRh().getEmail(), "Validation de votre congé",4);
			break;
			
		case 3 : 
			absence.setStatut(statutDao.findByCode(validation));
			break;
			
		case 4 : 
			absence.setStatut(statutDao.findByCode(validation));
			emailService.sendEmail(absence, absence.getEmploye().getUser().getEmail(),"Refus de votre congé par le responsable",5);
			break;
			
		case 5 : 
			absence.setStatut(statutDao.findByCode(validation));
			emailService.sendEmail(absence, absence.getEmploye().getUser().getEmail() ,"Refus de votre congé par le service RH",6);
			emailService.sendEmail(absence, absence.getEmploye().getEquipe().getResponsable().getUser().getEmail(),"Refus de votre congé par le service RH",7);
			break;
			
		case 6 :
			
		default :
			throw new ServiceException("Le statut n'existe pas");
		}
		
		absenceDao.save(absence);
		absenceDto = mapper.convertAbsToDto(absence);
		
		return absenceDto;
	}

}
