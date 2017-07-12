import React, {Component} from 'react';

import axios from 'axios';

import './site.css';

// Import des composants de la page
import Entete from './Entete/Entete.js';
import BarDeNav from './BarDeNav/BarDeNav.js';
import PiedPage from './PiedPage/PiedPage.js';
import Pages from './Pages/Pages.js';




// Ligne à occulter, sert à afficher l'environnement de Steven MERRIL
let email="steven.merrill@entreprise.com";




class Site extends Component {

      constructor(props) {
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
              absences:[]
        }
      }

      // traitement asynchrone dont le résutat est obtenu après récolte des données du back
      componentDidMount() {

          // Récupération des données du Back par requête HTTP
           axios.get('http://localhost:8080/user/getUser?email='+email) // Type GET paramétré avec l'email.
              .then(res => {
                  this.setState({ // Incorpore les données dans le State
                    nom: res.data[0].employeDto.nom,
                    prenom: res.data[0].employeDto.prenom,
                    matricule: res.data[0].employeDto.matricule,
                    email: res.data[0].employeDto.email,
                    role: res.data[0].employeDto.role,
                    nbCa: res.data[0].employeDto.nbCa,
                    nbRtt: res.data[0].employeDto.nbRtt,
                    nbRc: res.data[0].employeDto.nbRc,
                    nomRh: res.data[0].employeDto.nomRh,
                    emailRh: res.data[0].employeDto.emailRh,
                    nomEquipe: res.data[0].employeDto.nomEquipe,
                    nomResponsable: res.data[0].employeDto.nomResponsable,
                    prenomResponsable: res.data[0].employeDto.prenomResponsable,
                    emailResponsable: res.data[0].employeDto.emailResponsable,
                    absences: res.data[0].absenceDto // Rappel : Absence est un tableau de données.
                });
          });
      }


      // Post-traitement permettant d'afficher le résultat du componentDidMount
      // componentDidUpdate() {
      //   console.log(this.state);
      // }

    render() {
    return (
      <div>

        // Appel d'une page fille accompagnée des données issues du State
        <Entete
                nom={this.state.nom}
                prenom={this.state.prenom}
                nbCa={this.state.nbCa}
                nbRtt={this.state.nbRtt}
                nbRc={this.state.nbRc} /> {/* Affiche le header de la page */}

        // Appel d'une page sans données du State
        <BarDeNav />                      {/* Affiche la barre de navigation (latérale) */}
        <Pages employe={this.state} />    {/* Affiche le body en fonction de la navigation */}
        <PiedPage />                      {/* Affiche le footer */}
      </div>
    )
  }
}

export default Site;
