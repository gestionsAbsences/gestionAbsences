import React, { Component } from 'react';

import axios from 'axios';

import './nouvelledemande.css';

let absencePlaceholder="Choisir type d'absence";

class NouvelleDemande extends Component {

  constructor(props){
      super(props); // Récupère le Props du parent
      this.props=props;
      this.state={ // Définition des propriétés du State
        statut: '',
        type: '',
        debut: '',
        fin: '',
        commentaire: '',
        types: [],
        reqOk: false,
        issue: '',
        selectedId: 0
      };
      this.handleTypeChange = this.handleTypeChange.bind(this);
      this.handleDebutChange = this.handleDebutChange.bind(this);
      this.handleFinChange = this.handleFinChange.bind(this);
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
        this.setState({
          types: res.data,
        });
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
  }

  listeType = (indice, type) => {
    let res;
    if (indice!==3 && indice!==4) {
      res=<option key={indice}>{type}</option>;
    }
    return res;
  }

  handleDebutChange = (event) => {
    this.setState({debut: event.target.value, issue: ""});
  }

  handleFinChange = (event) => {
    this.setState({fin: event.target.value, issue: ""});
  }

  handleTypeChange = (event) => {
    this.setState({type: event.target.value, issue: ""});
  }

  handleSubmit(event) {
    this.setState({
      type: this.state.type,
      debut: this.state.debut,
      fin: this.state.fin
    });

    this.creerAbsence();
    event.preventDefault();
  }

  creerAbsence() {

    //Requête HTTP destinée au Back
    axios({
      method: 'post',
      url: '/absence/creerAbsence/',
      data: {
              debut: this.state.debut,
              fin: this.state.fin,
              type: this.state.type,
              statut: this.state.statut,
              matricule: this.props.employe.matricule
            },
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        }
      })
      .then(res => {

        // Incorpore les données dans le State
        this.setState({
          issue: "Votre demande a bien été prise en compte !",
          type: absencePlaceholder,
          debut: "",
          fin: ""
        });
        alert(this.state.issue);
        if (this.props.employe.modeDev) {
          console.log("Requête satisfaite : ");
          console.log(res);
          console.log("");
        }
      })

      // Traitement des erreurs en mode de Dev.
      .catch((error) => {
          if (axios.isCancel(error)) {
            if (this.props.employe.modeDev) {
              console.log("La requête a été annulée :");
              console.log('Request canceled', error.message);
              console.log("");
            }
            this.setState({issue: "Une erreur empêche la prise en compte de votre demande !"});alert(this.state.issue);
          } else if (error.response) {
            if (this.props.employe.modeDev) {
              console.log("La requête est transmise mais retourne une erreur <200 ou >=300 :");
              console.log(error.response.data);
              console.log(error.response.status);
              console.log(error.response.headers);
              console.log("");
            }
            this.setState({issue: "Une erreur empêche la prise en compte de votre demande !"});alert(this.state.issue);
          } else if (error.request) {
            if (this.props.employe.modeDev) {
              console.log("La requête est transmise mais ne retourne pas de réponse : ");
              console.log(error.request);
              console.log("");
            }
            this.setState({issue: "Une erreur empêche la prise en compte de votre demande !"});alert(this.state.issue);
          } else {
            this.setState({
              issue: "Votre demande a bien été prise en compte !",
              type: absencePlaceholder,
              debut: "",
              fin: ""
            });
            alert(this.state.issue);
          }
          //   console.log("La requête n'a pu être transmise et déclenche une erreur : ");
          //   console.log('Error', error.message);
          //   console.log("");
          //   this.setState({issue: "Une erreur empêche la prise en compte de votre demande !"});alert(this.state.issue);
          // }
          // console.log("Error.config : ");
          // console.log(error.config);
          // console.log("");
          // this.setState({issue: "Une erreur empêche la prise en compte de votre demande !"});alert(this.state.issue);
      });
    }

    annuler = () => {
      if (this.state.type===absencePlaceholder && this.state.debut==="" && this.state.fin==="") {
        return;
      };

      this.setState({
        type: absencePlaceholder,
        debut: "",
        fin: ""
      });
    }

    soumettre = () => {
    }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de Formulaire */}
            <div className="row">
              <div className="col-xs-6"><h3 className="panel-title">Nouvelle demande</h3></div>
              <div className="col-xs-6"><h3 className="panel-title pull-right red">{this.state.issue}</h3></div>
            </div>
          </div>   {/*3   fin */}
          <div className="panel-body">   {/*4   Contenu Formulaire */}
            <div className="VOffSetHautPages">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css VOffSetHautPages */}{/*5   fin */}
            <div className="row">
              <div className="col-md-4 col-md-offset-1">   {/*6   Formulaire Partie gauche */}
                <div className="form-group">{/*7   Un des champs select du Formulaire */}
                  <label>Type d'absence</label>{/*'*/}{/* Factice Pour rectifier bug d'affichage sur Atom */}

                  <select className="form-control" value={this.state.type} selected={this.selectedId} onChange={this.handleTypeChange}>
                    <option disabled>{absencePlaceholder}</option>
                    {this.state.types.map(
                      (type, i) =>
                      this.listeType(i, type.nom)
                    )}
                  </select>
                </div>   {/*7   fin */}
                <div className="form-group">   {/*9   Un des champ de saisie de type texte */}
                  <label>Date de début</label>
                    <input type="date" className="form-control" placeholder="Début" value={this.state.debut} onChange={this.handleDebutChange} />
                  </div>   {/*9   fin */}
                <div className="form-group">
                  <label>Date de fin</label>
                    <input type="date" className="form-control" placeholder="Fin" value={this.state.fin} onChange={this.handleFinChange} />
                </div>
              </div>   {/*6   fin */}
              <div className="col-md-4 col-md-offset-2">   {/*8   Block formulaire Partie droite */}
                <div className="form-group">
                  <label>Congés payés</label>
                  <label className="form-control">{this.props.employe.nbCa} jours</label>
                </div>
                <div className="form-group">
                  <label>RTT</label>
                  <label className="form-control">{this.props.employe.nbRtt} jours</label>
                </div>
                <div className="form-group">
                  <label>Repos compensateur</label>
                  <label className="form-control">{this.props.employe.nbRc} heures</label>
                </div>
                <div className="form-group">
                  <label>Valideur</label>
                  <label className="form-control">{this.props.employe.nomResponsable} {this.props.employe.prenomResponsable}</label>
                </div>
              </div>   {/*8   fin */}
            </div>
            <div className="row">   {/*11   Block Boutons Soumettre et Annuler */}
              <div className="VOffSetBasPages">&nbsp;</div>   {/*12   Cosmétique d'unee marge au dessus des boutons */}{/*12   fin */}
              <div className="col-md-2 col-md-offset-4 btn-bottom-marge">
                {/* <input className="btn btn-primary btn-block" type="submit" value="Soumettre" onClick={this.soumettre} /> */}
                <input className="btn btn-primary btn-block" type="submit" value="Soumettre" />
                {/* <button type="submit" className="btn btn-primary btn-block">Soumettre</button> */}
              </div>
              <div className="col-md-2">
              <input className="btn btn-primary btn-block btn-bottom-marge" type="reset" value="Annuler" onClick={this.annuler} />
              </div>
            </div>   {/*11   fin */}
          </div>   {/*4   fin */}
          <div className="VOffSetBasPages">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
        </div>   {/*2   fin */}
        <div className="VOffSetBasPages">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
        {/*
        <div className="container">
            <Text className="btn btn-primary btn-block" onPress={this.onPressHandle.bind(this)}>click me !</Text>
            <Popup ref={popup => this.popup = popup }/>
        </div>
        */}
      </form>
    );
  }
}

export default NouvelleDemande;
