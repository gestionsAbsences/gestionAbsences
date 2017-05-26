package co.simplon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JourNonTravaille {
	protected Calendar calendarDateEnCours              = Calendar.getInstance();
	protected Date     dateDateEnCours                  = null;
	protected String   stringDateEnCours                = "";
	protected boolean  dateEnCoursEstFeriee             = false;
	protected boolean  dateEnCoursEstReposHebdomadaire  = false;
	protected boolean  dateEnCoursEstNonTravaillee      = false;
	protected boolean  dateEnCoursEstJourFerieTravaille = false;
	protected int      intListeJoursFeriesTravailles    = 0;
	protected Calendar calendarListeDateJoursFeries[]   = new Calendar[13];
	protected Date     dateListeDateJoursFeries[]       = new Date[13];
	protected String   stringListeDateJoursFeries[]     = new String[13];
	protected String   stringListeStringJoursFeries[]   = new String[13];
	protected Calendar calendarDatePaques               = Calendar.getInstance();
	protected Date     dateDatePaques                   = null;
	protected String   stringDatePaques                 = "";
	protected String   stringJourDateEnCours            = "";
	protected String   stringMoisDateEnCours            = "";
	protected int      intAnneeDateEnCours              = 0;
	protected int      intJourDateEnCours               = 0;
	protected String   stringJourFerieDateEnCours       = "";
	protected int      confReposHebdomadaires           = 96;
	protected SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


	public JourNonTravaille() {
		this.dateDateEnCours = this.calendarDateEnCours.getTime();
		this.stringDateEnCours = this.sdf.format(this.dateDateEnCours);
	}

	public JourNonTravaille(Calendar cLaDate) {
		this.calendarDateEnCours = cLaDate;
		this.dateDateEnCours = this.calendarDateEnCours.getTime();
		this.stringDateEnCours = this.sdf.format(this.dateDateEnCours);
	}

	public JourNonTravaille(Date dLaDate) {
		this.stringDateEnCours = this.sdf.format(dLaDate);
		this.dateDateEnCours = dLaDate;
		this.calendarDateEnCours.setTime(dLaDate);
	}

	public JourNonTravaille(String sLaDate) throws ParseException {
		this.stringDateEnCours = sLaDate;
		this.dateDateEnCours = this.sdf.parse(sLaDate);
		this.calendarDateEnCours.setTime(this.dateDateEnCours);
	}

	public JourNonTravaille(Calendar cLaDate, int binJoursDeRepos) {
		this.calendarDateEnCours = cLaDate;
		this.dateDateEnCours = this.calendarDateEnCours.getTime();
		this.stringDateEnCours = this.sdf.format(this.dateDateEnCours);
		this.confReposHebdomadaires = binJoursDeRepos;
	}

	public JourNonTravaille(Date dLaDate, int binJoursDeRepos) {
		this.stringDateEnCours = this.sdf.format(dLaDate);
		this.dateDateEnCours = dLaDate;
		this.calendarDateEnCours.setTime(dLaDate);
		this.confReposHebdomadaires = binJoursDeRepos;
	}

	public JourNonTravaille(String sLaDate, int binJoursDeRepos) throws ParseException {
		this.stringDateEnCours = sLaDate;
		this.dateDateEnCours = this.sdf.parse(sLaDate);
		this.calendarDateEnCours.setTime(this.dateDateEnCours);
		this.confReposHebdomadaires = binJoursDeRepos;
	}

	public Calendar getCalendarDateEnCours() {
		return calendarDateEnCours;
	}

	public Date getDateDateEnCours() {
		return dateDateEnCours;
	}

	public String getStringDateEnCours() {
		return stringDateEnCours;
	}

	public boolean isDateEnCoursEstFeriee() {
		this.dateEnCoursEstFeriee = false;
		int i = -1;
		for (Calendar JF:getCalendarListeDateJoursFeries()) {
			i++;
			if (JF.get(Calendar.YEAR) == this.calendarDateEnCours.get(Calendar.YEAR) && JF.get(Calendar.MONTH) == this.calendarDateEnCours.get(Calendar.MONTH) && JF.get(Calendar.DAY_OF_MONTH) == this.calendarDateEnCours.get(Calendar.DAY_OF_MONTH)) {
				this.dateEnCoursEstFeriee = true;
				setStringJourFerieDateEnCours(getStringListeStringJoursFeries()[i]);
				if ((this.intListeJoursFeriesTravailles & ((int) Math.pow(2, i))) == (Math.pow(2, i))) {setDateEnCoursEstJourFerieTravaille(true);}
				break;
			}
		}
		return dateEnCoursEstFeriee;
	}

	public boolean isDateEnCoursEstJourFerieTravaille() {
		return dateEnCoursEstJourFerieTravaille;
	}

	public int getIntListeJoursFeriesTravailles() {
		return intListeJoursFeriesTravailles;
	}

	public boolean isDateEnCoursEstReposHebdomadaire() {
		this.dateEnCoursEstReposHebdomadaire = false;
		if ((calendarDateEnCours.get(Calendar.DAY_OF_WEEK) == 2) && ((this.confReposHebdomadaires & 1)  ==  1)) {this.dateEnCoursEstReposHebdomadaire = true;}  // lundi
		if ((calendarDateEnCours.get(Calendar.DAY_OF_WEEK) == 3) && ((this.confReposHebdomadaires & 2)  ==  2)) {this.dateEnCoursEstReposHebdomadaire = true;}  // mardi
		if ((calendarDateEnCours.get(Calendar.DAY_OF_WEEK) == 4) && ((this.confReposHebdomadaires & 4)  ==  4)) {this.dateEnCoursEstReposHebdomadaire = true;}  // mercredi
		if ((calendarDateEnCours.get(Calendar.DAY_OF_WEEK) == 5) && ((this.confReposHebdomadaires & 8)  ==  8)) {this.dateEnCoursEstReposHebdomadaire = true;}  // jeudi
		if ((calendarDateEnCours.get(Calendar.DAY_OF_WEEK) == 6) && ((this.confReposHebdomadaires & 16) == 16)) {this.dateEnCoursEstReposHebdomadaire = true;}  // vendredi
		if ((calendarDateEnCours.get(Calendar.DAY_OF_WEEK) == 7) && ((this.confReposHebdomadaires & 32) == 32)) {this.dateEnCoursEstReposHebdomadaire = true;}  // samedi
		if ((calendarDateEnCours.get(Calendar.DAY_OF_WEEK) == 1) && ((this.confReposHebdomadaires & 64) == 64)) {this.dateEnCoursEstReposHebdomadaire = true;}  // dimanche
		return dateEnCoursEstReposHebdomadaire;
	}

	public boolean isDateEnCoursEstNonTravaillee() {
		this.dateEnCoursEstNonTravaillee = (isDateEnCoursEstReposHebdomadaire() || (isDateEnCoursEstFeriee() && (!this.isDateEnCoursEstJourFerieTravaille())));
		return dateEnCoursEstNonTravaillee;
	}

	public Calendar[] getCalendarListeDateJoursFeries() {
	    Calendar cPaques = getCalendarDatePaques();
	    int annee = getIntAnneeDateEnCours();
		for (int i = 0; i < 13; i++) {this.calendarListeDateJoursFeries[i] = Calendar.getInstance();}
		this.calendarListeDateJoursFeries[0].set(annee, 0, 1);
		this.calendarListeDateJoursFeries[1] = (Calendar) cPaques.clone();
		this.calendarListeDateJoursFeries[2] = (Calendar) cPaques.clone(); this.calendarListeDateJoursFeries[2].add(Calendar.DAY_OF_MONTH, 1);
		this.calendarListeDateJoursFeries[3].set(annee, 4, 1);
		this.calendarListeDateJoursFeries[4].set(annee, 4, 8);
		this.calendarListeDateJoursFeries[5] = (Calendar) cPaques.clone(); this.calendarListeDateJoursFeries[5].add(Calendar.DAY_OF_MONTH, 39);
		this.calendarListeDateJoursFeries[6] = (Calendar) cPaques.clone(); this.calendarListeDateJoursFeries[6].add(Calendar.DAY_OF_MONTH, 49);
		this.calendarListeDateJoursFeries[7] = (Calendar) cPaques.clone(); this.calendarListeDateJoursFeries[7].add(Calendar.DAY_OF_MONTH, 50);
		this.calendarListeDateJoursFeries[8].set(annee, 6, 14);
		this.calendarListeDateJoursFeries[9].set(annee, 7, 15);
		this.calendarListeDateJoursFeries[10].set(annee, 10, 1);
		this.calendarListeDateJoursFeries[11].set(annee, 10, 11);
		this.calendarListeDateJoursFeries[12].set(annee, 11, 25);
		return calendarListeDateJoursFeries;
	}

	public Date[] getDateListeDateJoursFeries() {
		Calendar cJoursFeries[] = getCalendarListeDateJoursFeries();
		for (int i = 0; i < 13; i++) {
			this.dateListeDateJoursFeries[i] = cJoursFeries[i].getTime();
			}
		return dateListeDateJoursFeries;
	}

	public String[] getStringListeDateJoursFeries() {
		Date dJoursFeries[] = getDateListeDateJoursFeries();
		for (int i = 0; i < 13; i++) {
			this.stringListeDateJoursFeries[i] = this.sdf.format(dJoursFeries[i]);
			}
		return stringListeDateJoursFeries;
	}

	public String[] getStringListeStringJoursFeries() {
		this.stringListeStringJoursFeries[0]="jour de l'an";
		this.stringListeStringJoursFeries[1]="pâques";
		this.stringListeStringJoursFeries[2]="lundi de pâques";
		this.stringListeStringJoursFeries[3]="fête du travail";
		this.stringListeStringJoursFeries[4]="armistice du 8 mai 1945";
		this.stringListeStringJoursFeries[5]="ascension";
		this.stringListeStringJoursFeries[6]="pentecôte";
		this.stringListeStringJoursFeries[7]="lundi de pencôte";
		this.stringListeStringJoursFeries[8]="fête nationale";
		this.stringListeStringJoursFeries[9]="asomption";
		this.stringListeStringJoursFeries[10]="toussaint";
		this.stringListeStringJoursFeries[11]="armistice du 11 novembre 1918";
		this.stringListeStringJoursFeries[12]="noël";
		return stringListeStringJoursFeries;
	}

	public Calendar getCalendarDatePaques() {
	    int annee = getIntAnneeDateEnCours();
		int A = annee % 19;
		int B = annee % 4;
		int C = annee % 7;
		int D = ((A * 19) + 24) % 30;
		if (D == 29) {D = 28;}
		if ((D == 28) && (A > 10)) {D = 27;}
		int E = ((2 * B) + (4 * C) + (6 * D) + 5) % 7;
		if (D + E >= 10) {this.calendarDatePaques.set(annee, 3, D + E - 9);} else {this.calendarDatePaques.set(annee, 2, D + E);}
		return calendarDatePaques;
	}

	public Date getDateDatePaques() {
		this.dateDatePaques = getCalendarDatePaques().getTime();
		return dateDatePaques;
	}

	public String getStringDatePaques() {
		this.stringDatePaques = this.sdf.format(getDateDatePaques());
		return stringDatePaques;
	}

	public String getStringJourDateEnCours() {
		String sListJours[] = new String[8];
		sListJours[1]="dimanche";
		sListJours[2]="lundi";
		sListJours[3]="mardi";
		sListJours[4]="mercredi";
		sListJours[5]="jeudi";
		sListJours[6]="vendredi";
		sListJours[7]="samedi";
		this.stringJourDateEnCours = sListJours[getCalendarDateEnCours().get(Calendar.DAY_OF_WEEK)];
		return stringJourDateEnCours;
	}

	public String getStringMoisDateEnCours() {
		String sListMois[] = new String[12];
		sListMois[0]="janvier";
		sListMois[1]="février";
		sListMois[2]="mars";
		sListMois[3]="avril";
		sListMois[4]="mai";
		sListMois[5]="juin";
		sListMois[6]="juillet";
		sListMois[7]="août";
		sListMois[8]="septembre";
		sListMois[9]="octobre";
		sListMois[10]="novembre";
		sListMois[11]="décembre";
		this.stringMoisDateEnCours = sListMois[getCalendarDateEnCours().get(Calendar.MONTH)];
		return stringMoisDateEnCours;
	}

	public int getIntAnneeDateEnCours() {
	    this.intAnneeDateEnCours = this.calendarDateEnCours.get(Calendar.YEAR);
		return intAnneeDateEnCours;
	}

	public int getIntJourDateEnCours() {
	    this.intJourDateEnCours = this.calendarDateEnCours.get(Calendar.DAY_OF_MONTH);
		return intJourDateEnCours;
	}

	public String getStringJourFerieDateEnCours() {
		return stringJourFerieDateEnCours;
	}

	public int getConfReposHebdomadaires() {
		return confReposHebdomadaires;
	}



	public void setCalendarDateEnCours(Calendar calendarDateEnCours) {
		this.calendarDateEnCours = calendarDateEnCours;
	}

	public void setDateDateEnCours(Date dateDateEnCours) {
		this.dateDateEnCours = dateDateEnCours;
	}

	public void setStringDateEnCours(String stringDateEnCours) {
		this.stringDateEnCours = stringDateEnCours;
	}

	public void setDateEnCoursEstFeriee(boolean dateEnCoursEstFeriee) {
		this.dateEnCoursEstFeriee = dateEnCoursEstFeriee;
	}

	public void setDateEnCoursEstJourFerieTravaille(boolean dateEnCoursEstJourFerieTravaille) {
		this.dateEnCoursEstJourFerieTravaille = dateEnCoursEstJourFerieTravaille;
	}

	public void setIntListeJoursFeriesTravailles(int intListeJoursFeriesTravailles) {
		this.intListeJoursFeriesTravailles = intListeJoursFeriesTravailles;
	}

	public void setDateEnCoursEstReposHebdomadaire(boolean dateEnCoursEstReposHebdomadaire) {
		this.dateEnCoursEstReposHebdomadaire = dateEnCoursEstReposHebdomadaire;
	}

	public void setDateEnCoursEstNonTravaillee(boolean dateEnCoursEstNonTravaillee) {
		this.dateEnCoursEstNonTravaillee = dateEnCoursEstNonTravaillee;
	}

	public void setCalendarListeDateJoursFeries(Calendar[] calendarListeDateJoursFeries) {
		this.calendarListeDateJoursFeries = calendarListeDateJoursFeries;
	}

	public void setDateListeDateJoursFeries(Date[] dateListeDateJoursFeries) {
		this.dateListeDateJoursFeries = dateListeDateJoursFeries;
	}

	public void setStringListeDateJoursFeries(String[] stringListeDateJoursFeries) {
		this.stringListeDateJoursFeries = stringListeDateJoursFeries;
	}

	public void setStringListeStringJoursFeries(String[] stringListeStringJoursFeries) {
		this.stringListeStringJoursFeries = stringListeStringJoursFeries;
	}

	public void setCalendarDatePaques(Calendar calendarDatePaques) {
		this.calendarDatePaques = calendarDatePaques;
	}

	public void setDateDatePaques(Date dateDatePaques) {
		this.dateDatePaques = dateDatePaques;
	}

	public void setStringDatePaques(String stringDatePaques) {
		this.stringDatePaques = stringDatePaques;
	}

	public void setStringJourDateEnCours(String stringJourDateEnCours) {
		this.stringJourDateEnCours = stringJourDateEnCours;
	}

	public void setStringMoisDateEnCours(String stringMoisDateEnCours) {
		this.stringMoisDateEnCours = stringMoisDateEnCours;
	}

	public void setIntAnneeDateEnCours(int intAnneeDateEnCours) {
		this.intAnneeDateEnCours = intAnneeDateEnCours;
	}

	public void setIntJourDateEnCours(int intJourDateEnCours) {
		this.intJourDateEnCours = intJourDateEnCours;
	}

	public void setStringJourFerieDateEnCours(String stringJourFerieDateEnCours) {
		this.stringJourFerieDateEnCours = stringJourFerieDateEnCours;
	}

	public void setConfReposHebdomadaires(int confReposHebdomadaires) {
		this.confReposHebdomadaires = confReposHebdomadaires;
	}

}
