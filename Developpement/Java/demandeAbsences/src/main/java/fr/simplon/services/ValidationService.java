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
import fr.simplon.domain.Absence;
import fr.simplon.domain.Employe;
import fr.simplon.domain.Equipe;
import fr.simplon.domain.dto.AbsenceDto;
import fr.simplon.exception.ServiceException;
import fr.simplon.services.utils.EmailService;
import fr.simplon.services.utils.MapperDto;

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
	MapperDto mapper;

	public List<AbsenceDto> listeValidation(String nomEquipe, int statut) throws SQLException{
		Equipe equipe = equipeDao.findEquipeByNom(nomEquipe);
		List<Employe> employeByEquipe;
		
		List<Absence> absence;
		List<Absence> absenceEquipe = new ArrayList<>();
		List<AbsenceDto> absenceDto;
		employeByEquipe = employeDao.findByEquipe(equipe);
		
		for (Employe employe : employeByEquipe) {
			absence=employe.getAbsence();
			for (Absence abs : absence) {
				if(abs.getStatut().getCode()==statut){
				absenceEquipe.add(abs);
				}
			}
		}
		
		absenceDto = mapper.convertListeAbsenceToDto(absenceEquipe);
		
		
		return absenceDto;
	}
	
	public AbsenceDto updateValidation(AbsenceDto absenceDto, int validation) throws Exception{
		Employe employe = employeDao.findByMatricule(absenceDto.getMatricule());
		Absence absence;
		switch (validation){
		case  3 : 
			absenceDto.setStatut("En attente de décision RH");
			emailService.sendEmail(absenceDto, employe.getUser().getEmail(), "Validation de votre congé",2);
			emailService.sendEmail(absenceDto, employe.getServiceRh().getEmail(), "Validation de votre congé",3);
			break;
			
		case 4 : 
			absenceDto.setStatut("Validé");
			break;
			
		case 5 : 
			absenceDto.setStatut("Refusé par le responsable");
			emailService.sendEmail(absenceDto, employe.getUser().getEmail(),"Refus de votre congé par le responsable",4);
			break;
			
		case 6 : 
			absenceDto.setStatut("Refusé par le RH");
			emailService.sendEmail(absenceDto, employe.getUser().getEmail() ,"Refus de votre congé par le service RH",5);
			emailService.sendEmail(absenceDto, employe.getEquipe().getResponsable().getUser().getEmail(),"Refus de votre congé par le service RH",6);
			break;
			
		default :
			throw new ServiceException("Le statut n'existe pas");
		}
		
		absence = mapper.convertDtoToAbs(absenceDto);
		absenceDao.save(absence);
		absenceDto = mapper.convertAbsToDto(absence);
		
		return absenceDto;
	}

}
