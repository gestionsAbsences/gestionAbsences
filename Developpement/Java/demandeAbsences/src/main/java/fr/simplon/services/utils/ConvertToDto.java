package fr.simplon.services.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.simplon.common.ServiceException;
import fr.simplon.domain.Absence;
import fr.simplon.domain.Employe;
import fr.simplon.domain.User;
import fr.simplon.domain.dto.AbsenceDto;
import fr.simplon.domain.dto.EmployeDto;
import fr.simplon.domain.dto.UserDto;


@Service
public class ConvertToDto {
	
	public List<EmployeDto> convertListeEmployeToDto(List<Employe> employe){
		List<EmployeDto> resultatEmploye = new ArrayList<EmployeDto>();
		
		if(!employe.isEmpty()){
			for (Employe transfert : employe) {
				resultatEmploye.add(convertEmployeToDto(transfert));
			}
		} else {
			throw new ServiceException("Liste Employé vide");
		}
		
		return resultatEmploye;
	}
	
	public List<UserDto> convertListUserToDto(List<User> user){
		List<UserDto> resultatUser = new ArrayList<UserDto>();
		if(!user.isEmpty()){
			for (User transfert : user) {
				UserDto userDto = new UserDto();
				
				userDto.setEmail(transfert.getEmail());
				userDto.setPassword(transfert.getPasswd());
				userDto.setRole(transfert.getRole().getValeur());;
				userDto.setEmployeDto(convertEmployeToDto(transfert.getEmploye()));

				List<Absence> absence = transfert.getEmploye().getAbsence();
				userDto.setAbsenceDto((List<AbsenceDto>) convertListeAbsenceToDto(absence));

				
				resultatUser.add(userDto);
			}
		} else {
			throw new ServiceException("Liste User vide");
		}
		
		return resultatUser;
	}
	
	public List<AbsenceDto> convertListeAbsenceToDto(List<Absence> absence){
		List<AbsenceDto> resultatAbsence = new ArrayList<AbsenceDto>();
			for (Absence transfert : absence) {
				resultatAbsence.add(convertAbsenceToDto(transfert));
			}
		return resultatAbsence;
	}
	
	
	
	private EmployeDto convertEmployeToDto(Employe employe){
		EmployeDto employeDto = new EmployeDto();
		
				employeDto.setNom(employe.getNom());
				employeDto.setPrenom(employe.getPrenom());
				employeDto.setMatricule(employe.getMatricule());
				employeDto.setEmail(employe.getUser().getEmail());
				employeDto.setRole(employe.getUser().getRole().getValeur());;
				employeDto.setNbCa(employe.getNbCa());
				employeDto.setNbRtt(employe.getNbRtt());
				employeDto.setNbRc(employe.getNbRtt());
				employeDto.setNomRh(employe.getServiceRh().getNom());
				employeDto.setEmailRh(employe.getServiceRh().getEmail());
				employeDto.setNomEquipe(employe.getEquipe().getNom());
				employeDto.setNomResponsable(employe.getEquipe().getResponsable().getNom());
				employeDto.setEmailReponsable(employe.getEquipe().getResponsable().getUser().getEmail());
			
				return employeDto;
	}
	
	private AbsenceDto convertAbsenceToDto(Absence absence){
		
		AbsenceDto absenceDto = new AbsenceDto();
		
				absenceDto.setDebut(absence.getDebut());
				absenceDto.setFin(absence.getFin());
				absenceDto.setType(absence.getType().getNom());
				absenceDto.setStatut(absence.getStatut().getNom());
				
		return absenceDto;
	}

}
