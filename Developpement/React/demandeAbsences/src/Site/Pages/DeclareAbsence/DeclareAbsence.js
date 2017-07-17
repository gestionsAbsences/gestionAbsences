import React, { Component } from 'react';

import axios from 'axios';

import './declareabsence.css';

let typeDefaut="Choisir type d'absence";
let nomDefaut="Choisir nom de l'employé";
let prenomDefaut="Choisir prénom de l'employé";

class DeclareAbsence extends Component {

  constructor(props) {
    super(props);
    this.props = props;
    this.state={ // Définition des propriétés du State
      types: [],
      employes: [],
      statut: '',
      nom: '',
      prenom: '',
      type: '',
      nbCa: 0,
      nbRtt: 0,
      nbRc: 0,
      debut: '',
      fin: '',
      commentaire: '',
      selectedId: 0
    };

    this.handleNomChange = this.handleNomChange.bind(this);
    this.handlePrenomChange = this.handlePrenomChange.bind(this);
    this.handleTypeChange = this.handleTypeChange.bind(this);
    this.handleDebutChange = this.handleDebutChange.bind(this);
    this.handleFinChange = this.handleFinChange.bind(this);
    this.handleCommentaireChange = this.handleCommentaireChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    //Requête HTTP destinée au Back
    axios({
      method: 'get',
      url: '/type/listeTypeAbsence',
      data: {},
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        }
      })
      .then(res => {

        // Incorpore les données dans le State
        this.setState({types: res.data});
        if (this.props.employe.modeDev) {
          console.log("Requête satisfaite : ");
          console.log(res);
          console.log("");
        }
      })
      // Traitement des erreurs en mode de Dev.
      .catch((error) => {
        if (this.props.employe.modeDev) {
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

    //Requête HTTP destinée au Back
    axios({
      method: 'get',
      url: '/statut/getStatutByCode?code=0',
      data: {},
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        }
      })
      .then(res => {

        // Incorpore les données dans le State
        this.setState({statut: res.data.nom});
        if (this.props.employe.modeDev) {
          console.log("Requête satisfaite : ");
          console.log(res);
          console.log("");
        }
      })
      // Traitement des erreurs en mode de Dev.
      .catch((error) => {
        if (this.props.employe.modeDev) {
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

    //Requête HTTP destinée au Back
    axios({
      method: 'get',
      url: '/emp/listeEmployes',
      data: {},
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        }
      })
      .then(res => {

        // Incorpore les données dans le State
        this.setState({employess: res.data});

        if (this.props.employe.modeDev) {
          console.log("Requête satisfaite : ");
          console.log(res);
          console.log("");
        }
      })
      // Traitement des erreurs en mode de Dev.
      .catch((error) => {
        if (this.props.employe.modeDev) {
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

  listeType = (indice, type) => {
    let res;
    if (indice===3 || indice===4 || indice===5) {
      res=<option key={indice} id={indice}>{type}</option>;
    }
    return res;
  }

  selectNom = (i, employe, filtre) => {
    let res;
    console.log("Etape1");
    if (this.props.employe.nom===employe.nomResponsable && this.props.employe.prenom===employe.prenomResponsable) {
      res=<option key={i}>{employe.nom}</option>
      console.log("Etape2");
    }
    return res;
  }

  selectPrenom = (i, employe, filtre) => {
    let res;
    console.log("Etape1");
    if (this.props.employe.nom===employe.nomResponsable && this.props.employe.prenom===employe.prenomResponsable) {
      console.log("Etape2");
      res=<option key={i} id={i}>{employe.prenom}</option>
    }
    return res;
  }

  handleNomChange = (event) => {
    this.setState({nom: event.target.value});
  }

  handlePrenomChange = (event) => {
    this.setState({prenom: event.target.value});
  }

  handleTypeChange = (event) => {
    this.setState({type: event.target.value});
  }

  handleDebutChange = (event) => {
    this.setState({debut: event.target.value});
  }

  handleFinChange = (event) => {
    this.setState({fin: event.target.value});
  }

  handleCommentaireChange = (event) => {
    this.setState({commentaire: event.target.value});
  }

  handleSubmit(event) {
      event.preventDefault();
      this.setState({
        nom: this.state.nom,
        prenom: this.state.prenom,
        type: this.state.type,
        debut: this.state.debut,
        fin: this.state.fin,
        commentaire: this.state.commentaire,
        nbCa: this.state.nbCa,
        nbRtt: this.state.nbRtt,
        nbRc: this.state.nbRc
      });
      console.log("CréerAbsence :");
      console.log(this.state);
      this.creerAbsence();
  }

  creerAbsence() {
    axios
      .post('/absence/creerAbsence/',
          {
            debut: this.state.debut,
            fin: this.state.fin,
            type: this.state.type,
            statut: this.state.statut,
            matricule: this.props.employe.matricule
          })
      .then(res => {
      })
      .catch((error) => {
          console.log("Axios : Problème d'accès à la ressource /absence/creerAbsence/.");
          console.log(this.state.debut,this.state.fin,this.state.type,this.state.statut,this.props.employe.matricule);
      });
  }

  annuler = () => {
    if (this.state.type===typeDefaut && this.state.debut==="" && this.state.fin==="") {
      return;
    };

    this.setState({
      type: typeDefaut,
      debut: "",
      fin: ""
    });
  }

  render() {
    return (
      <form action="" onSubmit={this.handleSubmit}>
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de Formulaire */}
            <h3 className="panel-title">Declaration d'une absence inopinée</h3>                 {/*'*/}{/* Factice Pour rectifier bug d'affichage sur Atom */}
          </div>   {/*3   fin */}
          <div className="panel-body">   {/*4   Contenu Formulaire */}
            <div className="VOffSetHautPages">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css VOffSetHautPages */}{/*5   fin */}
            <div className="row">
              <div className="col-md-4 col-md-offset-1">   {/*6   Formulaire Partie gauche */}
                <div className="form-group">   {/*7   Un des champs select du Formulaire */}
                  <label>Nom de l'employé</label>{/*'*/}
                  <select className="form-control" value={this.state.nom} selected={this.selectedId} onChange={this.handleNomChange}>
                    <option id="0" disabled>{nomDefaut}</option>
                    {this.state.employes.map(
                      (employe, i) =>
                      this.selectNom(i, employe, this.state.nom)
                    )}
                  </select>
                </div>   {/*7   fin */}
                <div className="form-group">
                  <label>Prénom de l'employé</label>{/*'*/}
                  <select className="form-control" value={this.state.prenom} selected={this.selectedId} onChange={this.handlePrenomChange}>
                    <option id="0" disabled>{prenomDefaut}</option>
                    {this.state.employes.map(
                      (employe, i) =>
                      this.selectPrenom(i, employe, this.state.prenom)
                    )}
                  </select>
                </div>
                <div className="form-group">
                  <label>Type d'absence</label>                                           {/*'*/}
                  <select className="form-control" value={this.state.type} selected={this.selectedId} onChange={this.handleTypeChange}>
                    <option id="0" disabled>{typeDefaut}</option>
                    {this.state.types.map(
                      (type, i) =>
                      this.listeType(i, type.nom)
                    )}
                  </select>
                </div>
                <div className="VOffSetDecla">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css VOffSetHautPages */}{/*5   fin */}
                <div className="container-fluid">   {/*7   Les 3 labels pour les compteurs */}
                  <div className="text-center">
                    <div className="form-group col-md-4">
                      <label className="form-control">{this.state.nbCa} CP</label>
                    </div>
                    <div className="form-group col-md-4">
                      <label className="form-control">{this.state.nbRtt} RTT</label>
                    </div>
                    <div className="form-group col-md-4">
                      <label className="form-control">{this.state.nbRc} RC</label>
                    </div>
                  </div>
                </div>   {/*7   fin */}
              </div>   {/*6   fin */}
              <div className="col-md-4 col-md-offset-2">   {/*8   Block formulaire Partie droite */}
                <div className="form-group">   {/*9   Un des champ de saisie de type texte */}
                  <label>Date de début</label>
                  <input type="date" className="form-control" placeholder="Fin" onChange={this.handleDebutChange} />
                </div>   {/*9   fin */}
                <div className="form-group">
                  <label>Date de fin</label>
                  <input type="date" className="form-control" placeholder="Fin" onChange={this.handleFinChange} />
                </div>
                <div className="form-group">   {/*10   Champs de saisie de type Zone de texte */}
                  <label>Commentaires</label>
                  <textarea rows="5" className="form-control" onChange={this.handleCommentaireChange}></textarea>
                </div>   {/*10   fin */}
              </div>   {/*8   fin */}
              <div className="col-md-1"></div>
            </div>
            <div className="row">   {/*11   Block Boutons Soumettre et Annuler */}
              <div className="VOffSetBasPages">&nbsp;</div>   {/*12   Cosmétique d'unee marge au dessus des boutons */}{/*12   fin */}
              <div className="col-md-2 col-md-offset-4 btn-bottom-marge">
              <input className="btn btn-primary btn-block" type="submit" value="Soumettre" />
              </div>
              <div className="col-md-2 btn-bottom-marge">
              <input className="btn btn-primary btn-block btn-bottom-marge" type="reset" value="Annuler" onClick={this.annuler} />
              </div>
            </div>   {/*11   fin */}
          </div>   {/*4   fin */}
          <div className="VOffSetBasPages">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
        </div>   {/*2   fin */}
        <div className="VOffSetBasPages">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
      </form>
    );
  }
}

export default DeclareAbsence;
