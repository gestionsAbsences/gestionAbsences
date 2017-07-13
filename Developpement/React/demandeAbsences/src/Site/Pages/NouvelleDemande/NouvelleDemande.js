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
        selectedId: 0
      };
      this.handleTypeChange = this.handleTypeChange.bind(this);
      this.handleDebutChange = this.handleDebutChange.bind(this);
      this.handleFinChange = this.handleFinChange.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    axios
      .get('/type/listeTypeAbsence')
      .then(res => {
        this.setState({
          types: res.data
        });
      })
      .catch((error) => {
        console.log("Axios : Problème d'accès à la ressource /type/listeTypeAbsence.");
    });

    axios
      .get('/statut/getStatutByCode?code=0')
      .then(res => {
           this.setState({statut: res.data.nom});
         })
       .catch((error) => {
           console.log("Axios : Problème d'accès à la ressource /statut/getStatutByCode?code=0.");
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
    this.setState({debut: event.target.value,});
  }

  handleFinChange = (event) => {
    this.setState({fin: event.target.value,});
  }

  handleTypeChange = (event) => {
    this.setState({type: event.target.value,});
  }

  handleSubmit(event) {
      event.preventDefault();
      this.setState({
        type: this.state.type,
        debut: this.state.debut,
        fin: this.state.fin
      });
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
        console.log("Resultat création absence : ");
        console.log(res.data);
      })
      .catch((error) => {
          console.log("Axios : Problème d'accès à la ressource /absence/creerAbsence/.");
          console.log(this.state.debut,this.state.fin,this.state.type,this.state.statut,this.props.employe.matricule);
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

  render() {
    return (
      <form action="" onSubmit={this.handleSubmit}>
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de Formulaire */}
            <h3 className="panel-title">Nouvelle demande</h3>
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
              </div>
              <div className="col-md-2">
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

export default NouvelleDemande;
