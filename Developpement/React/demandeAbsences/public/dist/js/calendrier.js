var dateEnCours = new Date();
var listeJoursFeries = [];

var Jour = ["Di", "Lu", "Ma", "Me", "Je", "Ve", "Sa"];
var Mois = ["Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"];
var idCalendrierHtml = "table.calendrier";
var mois;
var annee;
var couleur = "normal";

// Données en dur pour tester
var idUser = 12;
var ConfJoursReposHebdo = 96;
var ConfFeriesTravailles = 0;
var users = [{id: 10, nom: "ARMAND", prenom: "Fulbert"}, {id: 11, nom: "CHAUMETTE", prenom: "Ernest"}, {id: 12, nom: "FARDET", prenom: "Gondran"}, {id: 13, nom: "FOURQUAY", prenom: "Anatole"}, {id: 14, nom: "URBAIN", prenom: "Gertrude"}];
var listeAbsences = [
	{id: 10, debut: "10/02/2017", fin: "10/02/2017", type: 2, statut: 1},
	{id: 10, debut: "24/02/2017", fin: "24/02/2017", type: 2, statut: 1},
	{id: 10, debut: "28/03/2017", fin: "30/03/2017", type: 3, statut: 1},
	{id: 10, debut: "20/04/2017", fin: "30/04/2017", type: 3, statut: 1},
	{id: 10, debut: "09/05/2017", fin: "01/06/2017", type: 1, statut: 0},
	{id: 10, debut: "02/06/2017", fin: "04/06/2017", type: 3, statut: 0},
	{id: 10, debut: "06/06/2017", fin: "09/06/2017", type: 1, statut: 0},
	{id: 11, debut: "02/01/2017", fin: "18/01/2017", type: 1, statut: 1},
	{id: 11, debut: "25/01/2017", fin: "26/01/2017", type: 4, statut: 1},
	{id: 11, debut: "05/02/2017", fin: "05/02/2017", type: 2, statut: 1},
	{id: 11, debut: "15/03/2017", fin: "30/03/2017", type: 1, statut: 1},
	{id: 11, debut: "09/04/2017", fin: "14/04/2017", type: 4, statut: 0},
	{id: 11, debut: "06/06/2017", fin: "09/06/2017", type: 1, statut: 1},
	{id: 11, debut: "12/06/2017", fin: "16/06/2017", type: 2, statut: 0},
	{id: 12, debut: "11/01/2017", fin: "12/01/2017", type: 3, statut: 1},
	{id: 12, debut: "22/01/2017", fin: "26/01/2017", type: 2, statut: 1},
	{id: 12, debut: "01/03/2017", fin: "22/03/2017", type: 1, statut: 1},
	{id: 12, debut: "24/04/2017", fin: "28/04/2017", type: 3, statut: 0},
	{id: 12, debut: "01/05/2017", fin: "22/05/2017", type: 1, statut: 0},
	{id: 12, debut: "02/06/2017", fin: "02/06/2017", type: 4, statut: 0},
	{id: 12, debut: "12/06/2017", fin: "16/06/2017", type: 2, statut: 1},
	{id: 12, debut: "17/06/2017", fin: "23/06/2017", type: 3, statut: 0},
	{id: 13, debut: "25/04/2017", fin: "07/05/2017", type: 1, statut: 1},
	{id: 13, debut: "17/06/2017", fin: "23/06/2017", type: 3, statut: 1},
	{id: 13, debut: "24/06/2017", fin: "30/06/2017", type: 4, statut: 0},
	{id: 14, debut: "24/06/2017", fin: "30/06/2017", type: 4, statut: 1}
];

$(document).ready(function() {

		$.ajax({
				type: "GET",
				url: "emp/listeEmployes",
			 //  data: {email:radio_button_value},
				success: function(response) {
					users = response;
					// console.log(users);
			 }
	 });

		$.ajax({
				type: "GET",
				url: "absence/listeAbsence",
			 //  data: {email:radio_button_value},
				success: function(response) {
					listeAbsences = response;
					// console.log(listeAbsences);
			 }
	 });

	 $(document).ajaxStop(function () {
			 // 0 === $.active
			//  console.log("GO !");
			 console.log(listeAbsences);

		afficherCalendrier();
		afficheLegend();
	});

	$('#leftcalendrier').click(function(){
		dateEnCours = new Date(annee, (mois - 1), 1);
		afficherCalendrier();
	});

	$('#rightcalendrier').click(function(){
		dateEnCours = new Date(annee, (mois + 1), 1);
		afficherCalendrier();
	});

	$('#todaycalendrier').click(function(){
		dateEnCours = new Date();
		afficherCalendrier();
	});

});

function leftCalendar() {
	dateEnCours = new Date(annee, (mois - 1), 1);
	afficherCalendrier();
}

function rightCalendar() {
		dateEnCours = new Date(annee, (mois + 1), 1);
		afficherCalendrier();
}

function todayCalendar() {
		dateEnCours = new Date();
		afficherCalendrier();
}

function afficherCalendrier() {
	if($('#moncalendrier').length) {
		viderElement(idCalendrierHtml);
		calendrierPerso();
	}
	if($('#calendriergroupe').length) {
		affLegende=false;
		viderElement(idCalendrierHtml);
		calendrierGroupe();
	}
}

function calendrierPerso() {
	viderElement(idCalendrierHtml);
	var date  = dateEnCours.getDate();
	var MoisAffiche = [3];
	var html = "";
	couleur = "jaune";
	mois = dateEnCours.getMonth();
	annee = dateEnCours.getFullYear();
	MoisAffiche[0] = new Date(annee, (mois - 1), 1);
	MoisAffiche[1] = new Date(annee, mois, 1);
	MoisAffiche[2] = new Date(annee, (mois + 1), 1);
	joursFeries();

	html = '<tr>';
	html += '<td class="' + couleur + ' mois border" colspan=7>' + Mois[MoisAffiche[0].getMonth()] + ' ' + MoisAffiche[0].getFullYear() + '</td>';
	html += '<td class="' + couleur + ' mois border" colspan=7>' + Mois[MoisAffiche[1].getMonth()] + ' ' + MoisAffiche[1].getFullYear() + '</td>';
	html += '<td class="' + couleur + ' mois border" colspan=7>' + Mois[MoisAffiche[2].getMonth()] + ' ' + MoisAffiche[2].getFullYear() + '</td>';
	html += '</tr>';
	$(idCalendrierHtml).append(html);

	html = "<tr>";
	for (var moisAffiche = 0; moisAffiche < 3; moisAffiche++) {
		for (var i = 1; i <= 7; i++) {
			bord = " borderB"
			if (i == 7) {bord += " borderR";}
			if (i == 1) {bord += " borderL";}
			if ((ConfJoursReposHebdo & Math.pow(2, (i - 1))) == Math.pow(2, (i - 1))) {couleur = "gris";} else {couleur = "jaune";}
			html+='<td class="' + couleur + bord + '">' + Jour[i % 7] + "</td>";
		}
	}
	html += "</tr>";
	$(idCalendrierHtml).append(html);

	for (var ligne = 0; ligne < 6; ligne++) {
		html = "<tr>";
		for (var moisAffiche = 0; moisAffiche < 3; moisAffiche++) {
			jourSemaine = MoisAffiche[moisAffiche].getDay();
			if (jourSemaine == 0) {jourSemaine = 7;}
			for (var jourAffiche = 1; jourAffiche <= 7; jourAffiche++) {
				couleur = "normal";
				dateAfficheeEnCours = new Date(annee, mois + moisAffiche - 1, (1 + jourAffiche + (ligne * 7) - jourSemaine));
				dateAffichee = '' + dateAfficheeEnCours.getDate();
				couleur = couleurCase(dateAfficheeEnCours, idUser);
				if (dateAfficheeEnCours.getMonth() == ((mois + moisAffiche + 11) % 12)) {
					police = " policeNormale"
					}
				else {
					if (couleur == "gris") {
						police = " policeClaire";
						} else {
						couleur = "normal";
						police = " policeEstompee;"}
					}
				bord = ""
				if (jourAffiche == 1) {bord += " borderL";}
				if (jourAffiche == 7) {bord += " borderR";}
				if (ligne == 5) {bord += " borderB";}
				html += '<td class="' + couleur + police + bord + '">'+dateAffichee+'</td>';
			}
		}
		html += "</tr>";
		$(idCalendrierHtml).append(html);
	}

}

function calendrierGroupe() {
	viderElement(idCalendrierHtml);
	var date  = dateEnCours.getDate();
	var html = "";
	couleur = "jaune";
	mois = dateEnCours.getMonth();
	annee = dateEnCours.getFullYear();
	var debut = new Date(annee, mois, -6);
	var fin   = new Date(annee, (mois + 1), 7);
	joursFeries();

	html = "<tr><td class='" + couleur + " border mois' rowspan=4>Equipe</td></tr>";
	html += "<tr>";
	html += "<td class='lienCalendrier " + couleur + " mois border' colspan=7><a onclick='leftCalendar()'>" + Mois[debut.getMonth()] + " " + debut.getFullYear() + "</a></td>";
	debut = new Date(annee, (mois + 1), 0);
	html += "<td class='lienCalendrier " + couleur + " mois border' colspan=" + debut.getDate() + "><a onclick='todayCalendar()'>" + Mois[debut.getMonth()] + " " + debut.getFullYear() + "</a></td>";
	debut = new Date(annee, (mois + 2), 0);
	html += "<td class='lienCalendrier " + couleur + " mois border' colspan=" + debut.getDate() + "><a onclick='rightCalendar()'>" + Mois[debut.getMonth()] + " " + debut.getFullYear() + "</a></td>";
	html += "</tr>";
	$(idCalendrierHtml).append(html);

	fin   = new Date(annee, (mois + 1), (7 + 31 - debut.getDate()));
	debut = new Date(annee, mois, -6);
	html = "<tr>";
	for (; debut <= fin;) {
		bord = "";
		couleur = "jaune";
		if (debut.getDate() == 1) {bord = " borderL";}
		if (debut.getDate() == fin.getDate() && debut.getMonth() == fin.getMonth()) {bord += " borderR";}
		couleur = couleurCase(debut, 0);
		html+='<td class="' + couleur + bord + '">' + Jour[debut.getDay()] + "</td>";
	    debut.setDate(debut.getDate() + 1);
	}
	html += "</tr>";
	$(idCalendrierHtml).append(html);

	debut = new Date(annee, mois, -6);
	html = "<tr>";
	for (; debut <= fin;) {
		bord = " borderB";
		couleur = "jaune";
		if (debut.getDate() == 1) {bord += " borderL";}
		if (debut.getDate() == fin.getDate() && debut.getMonth() == fin.getMonth()) {bord += " borderR";}
		couleur = couleurCase(debut, 0);
		html += '<td class="' + couleur + bord + '">' + debut.getDate() + "</td>";
	    debut.setDate(debut.getDate() + 1);
	}
	html += "</tr>";
	$(idCalendrierHtml).append(html);

	for (var i = 0; i < users.length; i++) {
		bord=" borderL borderR";
		if ((i+1) == users.length) {bord += " borderB";}
		html = '<tr><td class="bleuUser' + bord + '">' + users[i].nom + " " + users[i].prenom + "</td>";
		debut = new Date(annee, mois, -6);
		id = users[i].id;
		for (; debut <= fin;) {
			bord = "";
			couleur = "normal";
			if (debut.getDate() == 1) {bord = " borderL";}
			if (debut.getDate() == fin.getDate() && debut.getMonth() == fin.getMonth()) {bord += " borderR";}
			if ((i+1) == users.length) {bord += " borderB";}
			couleur = couleurCase(debut, id);
			html += '<td class="' + couleur + bord + '"></td>';
		    debut.setDate(debut.getDate() + 1);
		}
		html += "</tr>";
		$(idCalendrierHtml).append(html);
	}
}

function couleurCase(date, id) {
	var coulR = couleur;
	var listeCoulR = ["rouge", "bleu", "vert", "mauve"];
	var intensite = ["Estompe", ""];
	jour = date.getDay() - 1;
	if (jour < 0) {jour = 6;}
	if ((ConfJoursReposHebdo & Math.pow(2, jour)) == Math.pow(2, jour)) {return "gris";}
	for (var i = 0; i < listeJoursFeries.length; i++) {
		if (date.getDate() == listeJoursFeries[i].getDate() && date.getMonth() == listeJoursFeries[i].getMonth() && date.getFullYear() == listeJoursFeries[i].getFullYear()) {
			if ((ConfFeriesTravailles & Math.pow(2, i)) != Math.pow(2, i)) {return "gris";}
		}
	}
//	console.log(id);
	var employe=0;
	if (id > 0) {
		for (var i=0; i < listeAbsences.length; i++) {
			if (!(listeAbsences[i].employe > 0)) {employe = listeAbsences[i].employe.absence[0].employe;} else {employe = listeAbsences[i].employe;}
			// console.log("Employé = " + employe);
			// console.log("Début = " + listeAbsences[i].debut);
			// console.log("Fin = " + listeAbsences[i].fin);
			// console.log("Type = " + listeAbsences[i].type.id);
			// console.log("Statut = " + listeAbsences[i].statut.code);
			// console.log("");
			if (employe == id) {
	 			if (verifDates(date, listeAbsences[i].debut, listeAbsences[i].fin)) {
					coulR = listeCoulR[(listeAbsences[i].type.id - 1)] + intensite[listeAbsences[i].statut.code];
//					console.log(coulR + " - " + listeAbsences[i].type + " - " + listeCoulR[listeAbsences[i].type]+ " - " + intensite[listeAbsences[i].statut]);
				}
			}
		}
	}
	return coulR;
}

function verifDates(date, sDebut, sFin) {
	var resultat = false;

	if (sDebut.indexOf("-") > -1) {
		arrDeb = sDebut.split("-");
		debut =  new Date(arrDeb[0], arrDeb[1] - 1, arrDeb[2]);
	}	else {
		arrDeb = sDebut.split("/");
		debut =  new Date(arrDeb[2], arrDeb[1] - 1, arrDeb[0]);
	}

	if (sFin.indexOf("-") > -1) {
		arrFin = sFin.split("-");
		fin =  new Date(arrFin[0], arrFin[1] - 1, arrFin[2]);
	} else {
		arrFin = sFin.split("/");
		fin =  new Date(arrFin[2], arrFin[1] - 1, arrFin[0]);
	}

	// arrDeb = sDebut.split("/");
	// arrFin = sFin.split("/");
	//
	// debut =  new Date(arrDeb[2], arrDeb[1] - 1, arrDeb[0]);
	// fin   =  new Date(arrFin[2], arrFin[1] - 1, arrFin[0]);

	if (date >= debut && date <= fin) {resultat = true;}

	return resultat;
}

function  PaquesAdd(an, jAdd) {
	var calcJf;
	var A = an % 19;
	var B = an % 4;
	var C = an % 7;
	var D = ((A * 19) + 24) % 30;
	if (D == 29) {D = 28;}
	if ((D == 28) && (A > 10)) {D = 27;}
	var E = ((2 * B) + (4 * C) + (6 * D) + 5) % 7;
	if (D + E >= 10) {
		calcJf = new Date(an, 3, D + E - 9 + jAdd);
	} else {
		calcJf = new Date(an, 2, D + E + jAdd);
	}
	return calcJf;
}

function joursFeries() {
	listeJoursFeries = [
		new Date(annee + (mois > 9), 0, 1),
		PaquesAdd(annee + (mois > 9), 0),
		PaquesAdd(annee + (mois > 9), 1),
		new Date(annee, 4, 1),
		new Date(annee, 4, 8),
		PaquesAdd(annee, 39),
		PaquesAdd(annee, 49),
		PaquesAdd(annee, 50),
		new Date(annee, 6, 14),
		new Date(annee, 7, 15),
		new Date(annee - (mois < 3), 10, 1),
		new Date(annee - (mois < 3), 10, 11),
		new Date(annee - (mois < 3), 11, 25)
	];
	return true;
}

function transformDate(date) {
  return date.substr(-2) + "/" + date.substr(5,3) + "/" + date.substr(0,4);
}

function afficheLegend() {
	var liste=["Non travaillé", "Congé payé", "RTT", "Repos", "Autre"];
	var clrN=["gris", "rouge", "bleu", "vert", "mauve"];
	var clrE=["jaune", "rougeEstompe", "bleuEstompe", "vertEstompe", "mauveEstompe"];
	var mot="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	html ="<br><br>---Légende---<br><br>"
	$("#legendText").append(html);
	html ="<span class='"+clrN[0]+"'>"+mot+"</span> : " + liste[0]+"<br>"
	$("#legendText").append(html);
	for (i=1; i<5; i++) {
		html= "<span class='"+clrN[i]+"'>"+mot+"</span> : " + liste[i]+" validé <br>"
		html+="<span class='"+clrE[i]+"'>"+mot+"</span> : " + liste[i]+" en attente<br>"
		$("#legendText").append(html);
	}
}

/*  Fonction servant à vider de tous les éléments HTML le container associé à l'ID  */
function viderElement(id) {
  $(id).empty();  // Supprimer tous les éléments contenus dans le container lié à l'ID passé en argument.
  return true;
}
/***********************************************/
