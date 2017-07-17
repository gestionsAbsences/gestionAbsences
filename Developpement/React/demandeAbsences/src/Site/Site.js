import React, {Component} from 'react';

import axios from 'axios';

import './site.css';

// Import des composants de la page
import Entete from './Entete/Entete.js';
import BarDeNav from './BarDeNav/BarDeNav.js';
import PiedPage from './PiedPage/PiedPage.js';
import Pages from './Pages/Pages.js';

let userEmail;

let modeDev=true;
let modeDemo=true;

// userEmail="fred.couriol@laposte.fr";
userEmail="le19111967@gmail.com";
// userEmail="jeanlefrancois.simplon@gmail.com";
// userEmail="jean.lefrancois@laposte.net";
// userEmail="mokhtar.khider@gmail.com";

// userEmail="lucas.guyon@entreprise.com"

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

      propUserEmailMere = (valeur) => {
        userEmail=valeur;
      }

      // Traitement asynchrone dont le résultat est obtenu après récolte des données du back
      componentDidMount() {
        let getMail;

        if (modeDev) {
          getMail=userEmail;
        } else {
          getMail=this.state.userEmail;
        }

        //Récupération des données du Back par requête HTTP
        axios({
          method: 'get',
          url: '/user/getUser?email='+getMail,
          data: {},
          headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
          }
        })
          .then(res => {

            // Incorpore les données dans le State
            this.setState({
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

            if (modeDev) {
              this.setState({
                role: 7
              });
            }

            if (modeDev) {
              console.log("Requête satisfaite : ");
              console.log(res);
              console.log("");
            }
          })
          // Traitement des erreurs en mode de Dev.
          .catch((error) => {
            if (modeDev) {
              if (axios.isCancel(error)) {
                console.log("La requête a été annulée :");
                console.log('Request canceled', error.message);
                console.log("");
              } else if (error.response) {
                console.log("La requête est transmise mais retourne une erreur <200 ou >=300 :");
                console.log(error.response.data);
                console.log(error.response.status);
                console.log(error.response.headers);
                console.log("");
              } else if (error.request) {
                console.log("La requête est transmise mais ne retourne pas de réponse : ");
                console.log(error.request);
                console.log("");
              } else {
                console.log("La requête n'a pu être transmise et déclenche une erreur : ");
                console.log('Error', error.message);
                console.log("");
              }
              console.log("Error.config : ");
              console.log(error.config);
              console.log("");
            }
          });
        }

    render() {
    return (
      <div>
        {/*  Appel d'une page fille accompagnée des données issues du State */}
        <Entete
                nom={this.state.nom}
                prenom={this.state.prenom}
                matricule={this.state.matricule}
                nbCa={this.state.nbCa}
                nbRtt={this.state.nbRtt}
                nbRc={this.state.nbRc} />{/* Affiche le header de la page */}

        {/*  Appel d'une page sans les données du State */}
        <BarDeNav role={this.state.role} />{/* Affiche la barre de navigation (latérale) */}
        <Pages employe={this.state} transUserEmail={this.propUserEmailMere} />{/* Affiche le body en fonction de la navigation */}
        <PiedPage />{/* Affiche le footer */}
      </div>
    )
  }
}

export default Site;
