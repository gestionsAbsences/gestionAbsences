import React, {Component} from 'react';

import './site.css';

// Import des composants de la page
import Entete from './Entete/Entete.js';
import BarDeNav from './BarDeNav/BarDeNav.js';
import PiedPage from './PiedPage/PiedPage.js';
import Pages from './Pages/Pages.js';

let modeDev=true;
let modeDemo=true;

class Site extends Component {

      constructor() {
          super();

          // Définition des propriétés du State
          // Les propriétés sont relatives aux renseignements concernant l'utilisateur authentifié
          // ainsi que la liste de ses absences.
          this.state = {
              utilisateurConnecte: false,
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

      componentDidMount() {
        this.checkSessionStorage();
      }

      componentDidUpdate(prevProps, prevState) {
        sessionStorage.setItem('state', JSON.stringify(this.state));
      }

      checkSessionStorage = () => {
        try {
          if (sessionStorage.getItem('state') !== null) {
            this.setState((prevState) => {
              return prevState = JSON.parse(sessionStorage.getItem('state'))
            });
          }
        } catch (err) {
          if (this.state.modeDev) {
            console.log("Erreur sur storage :");
            console.log(err);
            console.log("");
          }
        }
      }

      getUser = (userConnecte) => {
        if (userConnecte===1 && this.state.utilisateurConnecte) {
          this.setState({
            utilisateurConnecte: true,
            nom: '',
            prenom: '',
            matricule: '',
            email: '',
            role: 0,
            nbCa: 0,
            nbRtt: 0,
            nbRc: 0,
            nomRh: 0,
            emailRh: 0,
            nomEquipe: '',
            nomResponsable: '',
            prenomResponsable: '',
            emailResponsable: '',
            absences: []
          })
        } else {
            this.setState({
              utilisateurConnecte: true,
              nom: userConnecte.employeDto.nom,
              prenom: userConnecte.employeDto.prenom,
              matricule: userConnecte.employeDto.matricule,
              email: userConnecte.email,
              role: userConnecte.role,
              nbCa: userConnecte.employeDto.nbCa,
              nbRtt: userConnecte.employeDto.nbRtt,
              nbRc: userConnecte.employeDto.nbRc,
              nomRh: userConnecte.employeDto.nomRh,
              emailRh: userConnecte.employeDto.emailRh,
              nomEquipe: userConnecte.employeDto.nomEquipe,
              nomResponsable: userConnecte.employeDto.nomResponsable,
              prenomResponsable: userConnecte.employeDto.prenomResponsable,
              emailResponsable: userConnecte.employeDto.emailResponsable,
              absences:  userConnecte.absenceDto
            })
          }
      }

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
        <Pages employe={this.state} getUser={this.getUser} uc={this.state.utilisateurConnecte} />{/* Affiche le body en fonction de la navigation */}
        <PiedPage />{/* Affiche le footer */}
      </div>
    )
  }
}

export default Site;
