var dateEnCours = new Date();
var listeJoursFeries = [];


// Données en dur pour l'affichage de la page du dossier
var Jour = ["Di", "Lu", "Ma", "Me", "Je", "Ve", "Sa"]; // Liste des jours de la semaine (raccourci)
var Mois = ["Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"];
var idCalendrierHtml = "table.calendrier";
var mois;
var annee;
var couleur = "normal";
var ConfJoursReposHebdo;
var ConfFeriesTravailles;
var idUser;
var nom;
var prenom;
var matricule;
var dev;
var demo=true;

// Données en dur pour tester
ConfJoursReposHebdo = 96; // Renseigne la configuration des jours de repos hebdomadaire
ConfFeriesTravailles = 0; // Renseigne les jours fériés travaillés
if (demo) {
  idUser = 12; // Identifie l'utilisateur
  users = [ // Liste de utilisateurs de l'équipe
  	{id: 10, nom: "DICKSON", prenom: "Jacob"},
  	{id: 11, nom: "WINTER", prenom: "Bryan"},
  	{id: 12, nom: "MERRIL", prenom: "Steven"},
  	{id: 13, nom: "MARQUEZ", prenom: "Skyler"},
  	{id: 14, nom: "BURT", prenom: "Eagan"}];
  listeAbsences = [
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
  	{id: 12, debut: "01/05/2017", fin: "22/05/2017", type: 1, statut: 1},
  	{id: 12, debut: "02/06/2017", fin: "02/06/2017", type: 4, statut: 1},
  	{id: 12, debut: "12/06/2017", fin: "16/06/2017", type: 2, statut: 1},
  	{id: 12, debut: "17/06/2017", fin: "23/06/2017", type: 3, statut: 0},
  	{id: 12, debut: "13/07/2017", fin: "13/07/2017", type: 4, statut: 0},
  	{id: 13, debut: "25/04/2017", fin: "07/05/2017", type: 1, statut: 1},
  	{id: 13, debut: "17/06/2017", fin: "23/06/2017", type: 3, statut: 1},
  	{id: 13, debut: "24/06/2017", fin: "30/06/2017", type: 4, statut: 0},
  	{id: 14, debut: "24/06/2017", fin: "30/06/2017", type: 4, statut: 1}
  ]; // Liste des absences concernant les membre de l'équipe
  // Fin de la section Données en dur
}

// Block exécuté au chargement
$(document).ready(function() {

  if (!demo) {
    // // Routine Ajax permettant d'exécuter une requête HTTP afin de récupérer des infos du Back en Json
    $.ajax({
      type: "GET",											// Type de requête
      url: "http://localhost:8080/emp/listeEmployes",					// URL de la requête
      success: function(response) {			// Exécute le block si la réponse est satisfaite (code 200)
        users = response; 			// Les données fournies sont stockées dans la variable listeAbsences
      }
    });

    // // Routine Ajax permettant d'exécuter une requête HTTP afin de récupérer des infos du Back en Json
    $.ajax({
      type: "GET",											// Type de requête
      url: "http://localhost:8080/absence/listeAbsence",					// URL de la requête
      success: function(response) {			// Exécute le block si la réponse est satisfaite (code 200)
        listeAbsences = response; 			// Les données fournies sont stockées dans la variable listeAbsences
      }
    });
    // // JS poursuit ses traitements même si le traitement Ajax n'est pas terminé.
    //
    // // Le traitement Ajax étant asynchrone par rapport à JS, la routine ci-dessous permet d'exécuter le block
    // // une fois la récupération des données est complète.
    $(document).ajaxStop(function () {
      afficherCalendrier();
      afficheLegend();
    });
  } else {
    afficherCalendrier();
    afficheLegend();
  }
	// Gestion du bouton gauche décalant d'un mois en arrière le calendrier.
	$('#leftcalendrier').click(function(){ // Gestion du bouton Aller à Gauche
		dateEnCours = new Date(annee, (mois - 1), 1); // Décalage d'un mois en arrière de la date de référence.
		afficherCalendrier();
	});

	$('#rightcalendrier').click(function(){ // Gestion du bouton Aller à Droite
		dateEnCours = new Date(annee, (mois + 1), 1); // Décalage d'un mois en avant de la date de référence.
		afficherCalendrier();
	});

	$('#todaycalendrier').click(function(){ // Gestion du bouton Aller à aujourd'hui
		dateEnCours = new Date(); // Règle la date de référence à aujourd'hui
		afficherCalendrier();
	});

});

// Alternative aux boutons de déplacement
// Les 3 fonctions ci-dessus servent à procéder au décalage du mois
// de référence à partir d'un click sur les entêtes du calendrie.
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
// -----------------------------------------------------------------------------

function afficherCalendrier() {       // Affiche le calendrier selon le cas attendu
	if($('#moncalendrier').length) {    // Vérifie la présence de l'élément identifié par l'id moncalendrier
		viderElement(idCalendrierHtml);   // Efface le contenu de l'élément HTML
		calendrierPerso();                // Affiche le calendrier perso
	}
	if($('#calendriergroupe').length) { // Vérifie la présence de l'élément identifié par l'id calendriergroupe
		affLegende=false;                 // Variable définissant la présence ou non de la légende
		viderElement(idCalendrierHtml);   // Efface le contenu de l'élément HTML
		calendrierGroupe();               // Affiche le calendrier de groupe (Equipe ou Entreprise)
	}
}

function calendrierPerso() {          // Permet d'afficher le calendrier personnel
	viderElement(idCalendrierHtml);
	var date  = dateEnCours.getDate();
	var MoisAffiche = [3];
	var html = "";
	couleur = "jaune";
	mois = dateEnCours.getMonth();
	annee = dateEnCours.getFullYear();
	MoisAffiche[0] = new Date(annee, (mois - 1), 1); // Calcul du mois antérieur
	MoisAffiche[1] = new Date(annee, mois, 1);       // Calcul du mois de référence
	MoisAffiche[2] = new Date(annee, (mois + 1), 1); // Calcul du mois postérieur
	joursFeries(); // Vérifie et colorise les jours fériés sur la période en cours

  // Affichage de l'entête du calendrier personnel
	// La variable html sert à consituter le code HTML à insérer dans l'élément prévu à cet effet.
	html = '<tr>';
	html += '<td class="' + couleur + ' mois border" colspan=7>' + Mois[MoisAffiche[0].getMonth()] + ' ' + MoisAffiche[0].getFullYear() + '</td>';
	html += '<td class="' + couleur + ' mois border" colspan=7>' + Mois[MoisAffiche[1].getMonth()] + ' ' + MoisAffiche[1].getFullYear() + '</td>';
	html += '<td class="' + couleur + ' mois border" colspan=7>' + Mois[MoisAffiche[2].getMonth()] + ' ' + MoisAffiche[2].getFullYear() + '</td>';
	html += '</tr>';
	$(idCalendrierHtml).append(html); // Routine jQuery permettant d'ajouter html au composant identifié par l'id idCalendrierHtml

  // Affichage de la ligne des jours de la semaine
	html = "<tr>";
	for (var moisAffiche = 0; moisAffiche < 3; moisAffiche++) {
		for (var i = 1; i <= 7; i++) {
			// Les variables Bordure servent à adapter la bordure en fonction du cas de figure
			bord = " borderB"
			if (i == 7) {bord += " borderR";}
			if (i == 1) {bord += " borderL";}
			// ConfJoursReposHebdo correspond à la configuration des jours de repos hebdomadaire
			// Son utilisation est régit par un masque binaire sur 7 bits (1 bit par jour, du lundi au dimanche)
			// Ex : Si ConfJoursReposHebdo = 96, les jours de repos hebdomadaire équivalent à samedi et dimanche.
			if ((ConfJoursReposHebdo & Math.pow(2, (i - 1))) == Math.pow(2, (i - 1))) {couleur = "gris";} else {couleur = "jaune";}
			html+='<td class="' + couleur + bord + '">' + Jour[i % 7] + "</td>"; // I modulo 7 sert à affecter la valeur 7 à dimanche
		}
	}
	html += "</tr>";
	$(idCalendrierHtml).append(html); // Ajouter html à l'élément

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
				//if (!(listeAbsences.employe > 0)) {employe = listeAbsences.employe.absence.employe;} else {employe = listeAbsences.employe;}
				// if (!(listeAbsences[i].employe > 0)) {employe = listeAbsences[i].employe.absence[0].employe;} else {employe = listeAbsences[i].employe;}
				// console.log("Employé = " + employe);
				// console.log("Début = " + listeAbsences[i].debut);
				// console.log("Fin = " + listeAbsences[i].fin);
				// console.log("Type = " + listeAbsences[i].type.id);
				// console.log("Statut = " + listeAbsences[i].statut.code);
				// console.log("");
				// if (employe == id) {
				// console.log(listeAbsences[i].id);
				// console.log(id);
				if (listeAbsences[i].id == id) {
					// if (verifDates(date, listeAbsences[i].debut, listeAbsences[i].fin)) {
					if (verifDates(date, listeAbsences[i].debut, listeAbsences[i].fin)) {
						coulR = listeCoulR[(listeAbsences[i].type - 1)] + intensite[listeAbsences[i].statut];
						// coulR = listeCoulR[(listeAbsences[i].type.id - 1)] + intensite[listeAbsences[i].statut.code];

						//					// console.log(coulR + " - " + listeAbsences[i].type + " - " + listeCoulR[listeAbsences[i].type]+ " - " + intensite[listeAbsences[i].statut]);
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
