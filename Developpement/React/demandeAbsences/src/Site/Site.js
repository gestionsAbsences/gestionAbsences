import React, {Component} from 'react';

import './site.css';

// Import des composants de la page
import Entete from './Entete/Entete.js';
import BarDeNav from './BarDeNav/BarDeNav.js';
import PiedPage from './PiedPage/PiedPage.js';
import Pages from './Pages/Pages.js';

// let userEmail;

let modeDev=true;
let modeDemo=true;

// userEmail="fred.couriol@laposte.fr";
// userEmail="le19111967@gmail.com";
// userEmail="jeanlefrancois.simplon@gmail.com";
// userEmail="jean.lefrancois@laposte.net";
// userEmail="mokhtar.khider@gmail.com";


class Site extends Component {

      constructor() {
          super();

          // Définition des propriétés du State
          // Les propriétés sont relatives aux renseignements concernant l'utilisateur authentifié
          // ainsi que la liste de ses absences.
          this.state = {
              nom:"",
              prenom:"",
              matricule:"",
              email:"",
              role:0,
              nbCa:0,
              nbRtt:0,
              nbRc:0,
              nomRh:"",
              emailRh:"",
              nomEquipe:"",
              nomResponsable:"",
              prenomResponsable:"",
              emailResponsable:"",
              absences:[],
              modeDev: modeDev,
              modeDemo: modeDemo
          }
      }

      getUser = (mecConnecte) => {
            this.setState({
              nom: mecConnecte.employeDto.nom,
              prenom: mecConnecte.employeDto.prenom,
              matricule: mecConnecte.employeDto.matricule,
              email: mecConnecte.employeDto.email,
              role: mecConnecte.role,
              nbCa: mecConnecte.employeDto.nbCa,
              nbRtt: mecConnecte.employeDto.nbRtt,
              nbRc: mecConnecte.employeDto.nbRc,
              nomRh: mecConnecte.employeDto.nomRh,
              emailRh: mecConnecte.employeDto.emailRh,
              nomEquipe: mecConnecte.employeDto.nomEquipe,
              nomResponsable: mecConnecte.employeDto.nomResponsable,
              prenomResponsable: mecConnecte.employeDto.prenomResponsable,
              emailResponsable: mecConnecte.employeDto.emailResponsable,
              absences:  mecConnecte.absenceDto,
            })
            console.log("Utilisateur connecté : ");
            console.log(this.state);
            console.log("");
      }

      // propUserEmailMere = (valeur) => {
      //   userEmail=valeur;
      // }

    render() {
    return (
      <div>{/*  Appel d'une page fille accompagnée des données issues du State */}
        <Entete
                nom={this.state.nom}
                prenom={this.state.prenom}
                matricule={this.state.matricule}
                nbCa={this.state.nbCa}
                nbRtt={this.state.nbRtt}
                nbRc={this.state.nbRc} />{/* Affiche le header de la page */}

        {/*  Appel d'une page sans les données du State */}
        <BarDeNav role={this.state.role} />{/* Affiche la barre de navigation (latérale) */}
        <Pages employe={this.state} userActuel={this.getUser} />{/* Affiche le body en fonction de la navigation */}
        <PiedPage />{/* Affiche le footer */}
      </div>
    )
  }
}

export default Site;
