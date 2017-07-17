import React, { Component } from 'react';

import axios from 'axios';

import './gestionpersonnel.css';

let nom="PEREZ";

let equipePlaceholder="Choisir équipe";
// let responsablePlaceholder="Choisir responsable";
// let backupPlaceholder="Choisir backup";
let sceRhPlaceholder="Choisir Service RH";

class GestionPersonnel extends Component {

    constructor(props) {
        super(props);
        this.state = {
          nom: "",
          prenom: "",
          matricule: "",
          email: "",
          equipe: "",
          sceRh: "",
          responsable: "",
          backup: "",
          types: [],
          equipes: [],
          sceRhs: [],
          responsables: []
      }
    }

  componentDidMount() {
      axios.get('/emp/getEmploye?nom='+nom)
          .then(res => {
              this.setState({
                nom: res.data[0].nomResp,
                prenom: res.data[0].prenomResp,
                nbCa: res.data[0].nbCa,
                nbRtt: res.data[0].nbRtt,
                nbRc: res.data[0].nbRc
            });
      });

      axios.get('/type/listeTypeAbsence')
          .then(res => {
              this.setState({
                types: res.data
          });
     });

     axios.get('/equipe/listeEquipe')
          .then(res => {
              this.setState({
                equipes: res.data
          });
    });

    axios.get('/rh/listeService')
          .then(res => {
              this.setState({
                sceRhs: res.data
          });
    });

}

  handleEquipeChange = (event) => {
    this.setState({equipe: event.target.value,});
  }

  handleResponsableChange = (event) => {
    this.setState({responsable: event.target.value,});
  }

  handleBackupChange = (event) => {
    this.setState({backup: event.target.value,});
  }

  handleSceRhChange = (event) => {
    this.setState({sceRh: event.target.value,});
  }


  annuler = () => {
    if (this.state) {
      return;
    };

    this.setState({
      nom: "",
      prenom: "",
      matricule: "",
      email: "",
      equipe: "",
      sceRh: "",
      responsable: "",
      backup: ""
    });
  }

  render() {
    return (
      <div>
        <div className="panel panel-default">{/*2   Formulaire */}
          <div className="panel-heading">{/*3   Titre de Formulaire */}
            <h3 className="panel-title">Gestion du personnel</h3>{/* Factice Pour rectifier bug d'affichage sur Atom */}
          </div>{/*3   fin */}
          <div className="panel-body">{/*4   Contenu Formulaire */}
            <div className="VOffSetHautPages">&nbsp;</div>{/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css VOffSetHautPages */}{/*5   fin */}
            <div className="row">
              <div className="col-md-4 col-md-offset-1">{/*6   Formulaire Partie gauche */}
                <div className="form-group">{/*7   Un des champs select du Formulaire */}
                  <label>Nom de l'employé</label>{/*'*/}
                  <input className="form-control" placeholder="Nom de l'employé" />
                </div>{/*7   fin */}
                <div className="form-group">
                  <label>Prénom de l'employé</label>                                     {/*'*/}
                  <input className="form-control" placeholder="Prénom de l'employé" />
                </div>
                <div className="form-group">
                  <label>Matricule de l'employé</label>                                     {/*'*/}
                  <input className="form-control" placeholder="Matricule de l'employé" />
                </div>
                <div className="form-group">
                  <label>Adresse mail de l'employé</label>                                     {/*'*/}
                  <input className="form-control" placeholder="Adresse mail de l'employé" />
                </div>
              </div>{/*6   fin */}
              <div className="col-md-4">{/*8   Block formulaire Partie droite */}
                <div className="form-group">
                  <label>Equipe</label>
                  <select className="form-control" value={this.state.equipe} selected={this.selectedId} onChange={this.handleEquipeChange}>
                    <option disabled>{equipePlaceholder}</option>
                    {this.state.equipes.map(
                      (equipe, i) =>
                      <option key={i}>{equipe}</option>
                    )}
                  </select>
                </div>
{/*
                <div className="form-group">
                  <label>Responsable</label>
                  <select className="form-control" value={this.state.responsable} selected={this.selectedId} onChange={this.handleBackupChange}>
                    <option disabled>{equipePlaceholder}</option>
                    {this.state.responsables.map(
                      (responsable, i) =>
                      <option key={i}>{responsable}</option>
                    )}
                  </select>
                </div>
                <div className="form-group">
                  <label>Backup</label>
                  <select className="form-control" value={this.state.backup} selected={this.selectedId} onChange={this.handleBackupChange}>
                    <option disabled>{backupPlaceholder}</option>
                    {this.state.backups.map(
                      (backup, i) =>
                      <option key={i}>{backup}</option>
                    )}
                  </select>
                </div>
*/}
                <div className="form-group">
                  <label>Service RH</label>
                  <select className="form-control" value={this.state.sceRh} selected={this.selectedId} onChange={this.handleSceRhChange}>
                    <option disabled>{sceRhPlaceholder}</option>
                    {this.state.sceRhs.map(
                      (sceRh, i) =>
                      <option key={i}>{sceRh}</option>
                    )}
                  </select>
                </div>
              </div>{/*8   fin */}
              <div className="col-md-2">
                <div className="form-group ">
                  <div className="panel panel-default">
                    <div className="panel-heading">{/*3   Titre de Formulaire */}
                      <h3 className="panel-title">Droits d'accès</h3>{/* Factice Pour rectifier bug d'affichage sur Atom */}
                    </div>{/*3   fin */}
                    <div className="panel-body">{/*4   Contenu Formulaire */}
                      <div className="VOffSetGest1">&nbsp;</div>
                      <div className="checkbox">
                        <label>&nbsp;&nbsp;
                          <input type="checkbox" value=""/>Valideur
                        </label>
                      </div>
                      <div className="VOffSetGest1">&nbsp;</div>
                      <div className="checkbox">
                        <label>&nbsp;&nbsp;
                          <input type="checkbox" value=""/>Valideur RH
                        </label>
                      </div>
                      <div className="VOffSetGest1">&nbsp;</div>
                      <div className="checkbox">
                        <label>&nbsp;&nbsp;
                          <input type="checkbox" value=""/>Administrateur
                        </label>
                      </div>
                    </div>
                  </div>
                </div>
                <div className="VOffSetGest2">&nbsp;</div>
                <div className="form-group btn-bottom-marge">
                  <a href="index.html" className="btn btn-primary btn-md btn-block">Réinitialisation<br/>du mot de passe</a>
                </div>
              </div>
            </div>
            <div className="row">{/*11   Block Boutons Soumettre et Annuler */}
              <div className="VOffSetBasPages">&nbsp;</div>{/*12   Cosmétique d'unee marge au dessus des boutons */}{/*12   fin */}
              <div className="col-md-10 col-md-offset-1">
                <div className="col-md-2 col-md-offset-4 btn-bottom-marge">
                  <input className="btn btn-primary btn-block btn-bottom-marge" type="reset" value="Annuler" onClick={this.precedent} />
                </div>
                <div className="col-md-2 btn-bottom-marge">
                  <input className="btn btn-primary btn-block btn-bottom-marge" type="reset" value="Annuler" onClick={this.suivant} />
                </div>
              </div>
            </div>
            <div className="row">{/*11   Block Boutons Soumettre et Annuler */}
              <div className="VOffSetBasPages">&nbsp;</div>{/*12   Cosmétique d'unee marge au dessus des boutons */}{/*12   fin */}
              <div className="col-md-10 col-md-offset-1">
                <div className="col-md-3 btn-bottom-marge">
                  <input className="btn btn-primary btn-block btn-bottom-marge" type="reset" value="Annuler" onClick={this.nouveau} />
                </div>
                <div className="col-md-3 btn-bottom-marge">
                  <input className="btn btn-primary btn-block btn-bottom-marge" type="reset" value="Annuler" onClick={this.supprimer} />
                </div>
                <div className="col-md-3 btn-bottom-marge">
                  <input className="btn btn-primary btn-block" type="submit" value="Enregistrer" />
                </div>
                <div className="col-md-3 btn-bottom-marge">
                  <input className="btn btn-primary btn-block btn-bottom-marge" type="reset" value="Annuler" onClick={this.annuler} />
                </div>
              </div>
            </div>
          </div>{/*4   fin */}
          <div className="VOffSetBasPages">&nbsp;</div>{/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
        </div>{/*2   fin */}
        <div className="VOffSetBasPages">&nbsp;</div>{/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
      </div>
    );
  }
}

export default GestionPersonnel;
