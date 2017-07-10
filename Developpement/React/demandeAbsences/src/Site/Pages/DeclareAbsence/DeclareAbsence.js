import React, { Component } from 'react';

import axios from 'axios';

import './declareabsence.css';

let absenceDefaut="Choisir type d'absence";

class DeclareAbsence extends Component {

  constructor(props) {
    super(props);
    this.props = props;
    this.state={ // Définition des propriétés du State
      types: [],
      noms: [],
      prenoms: [],
      statut: '',
      nom: '',
      prenom: '',
      type: '',
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
  axios
  .get('http://localhost:8080/type/listeTypeAbsence')
  .then(res => {
    this.setState({
      types: res.data
    });
  })
  .catch((error) => {
    console.log("Axios : Problème d'accès à la ressource http://localhost:8080/type/listeTypeAbsence.");
  });
}

  listeType = (indice, type) => {
    let res;
    if (indice===3 || indice===4 || indice===5) {
      res=<option key={indice} id={indice}>{type}</option>;
    }
    return res;
  }

  trtNom = (filtre) => {
    let res;
    if (filtre==="") {
      res=<input className="form-control" placeholder="Nom de l'employé" onChange={this.handleNomChange} />;
    } else {
      axios
      .get('http://localhost:8080/emp/getEmploye?nom='+filtre)
      .then(res => {
        this.setState({
          noms: res.data
        });
      })
      .catch((error) => {
        console.log("Axios : Problème d'accès à la ressource http://localhost:8080/type/listeTypeAbsence.");
      });
      res=<select className="form-control" value={this.state.nom} onChange={this.handleNomChange}>
        {this.state.noms.map(
          (nom, i) =>
          <option key={i} id={i}>{nom}</option>
        )}
        </select>;
    }
    return res;
  }

  handleNomChange = (event) => {
    // let nom=event.target.value;
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
console.log(this.state);
  this.creerAbsence();
  }

  formatDate = (date) => { // Convertit la date au format dd/mm/aaaa
    return (
      date.substr(-2) + "/" + date.substr(5,2) + "/" + date.substr(0,4)
    )
  }

  creerAbsence() {
    axios.get('http://localhost:8080/statut/getStatutByCode?code=0')
      .then(res => {
           console.log(res.data.nom);
           this.setState({statut: res.data.nom});
      });

    // @param id,
    //           date debut, datefin, idEmploye, Type de congé, Statut du
    //           congé, ServiceRh, types, statuts, valideurRh, employes;
    axios
    .post('http://localhost:8080/absence/creerAbsence/',
        {
          "nom": this.formatDate(this.state.nom),
          "prenom": this.formatDate(this.state.prenom),
          "type": this.state.type,
          "debut": this.formatDate(this.state.debut),
          "fin": this.formatDate(this.state.fin),
          "commentaire": this.state.commentaire,
          "statut": this.state.statut,
          "numDemande": 0
        })
    .then(res => {
      console.log("Resultat du POST : " + res);
    })
    .catch((error) => {
        console.log("Axios : Problème d'accès à la ressource http://localhost:8080/absence/creerAbsence/.");
      });
  }

  annuler = () => {
    if (this.state.type===absenceDefaut && this.state.debut==="" && this.state.fin==="") {
      return;
    };

    this.setState({
      type: absenceDefaut,
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
                  <label>Nom de l'employé</label>                                       {/*'*/}
                  {this.trtNom("")}
{/*                  <input className="form-control" placeholder="Nom de l'employé" onChange={this.handleNomChange} /> */}
                </div>   {/*7   fin */}
                <div className="form-group">
                  <label>Prénom de l'employé</label>                                     {/*'*/}
                  <input className="form-control" placeholder="Prénom de l'employé" onChange={this.handlePrenomChange} />
                </div>
                <div className="form-group">
                  <label>Type d'absence</label>                                           {/*'*/}
                  <select className="form-control" value={this.state.type} selected={this.selectedId} onChange={this.handleTypeChange}>
                    <option id="0" disabled>{absenceDefaut}</option>
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
