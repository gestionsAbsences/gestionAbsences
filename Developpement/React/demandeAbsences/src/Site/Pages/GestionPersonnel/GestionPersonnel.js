import React, { Component } from 'react';

import axios from 'axios';

// import '../../Bootstrap/dist/css/sb-admin-2.css'
import './gestionpersonnel.css';

let nom="PEREZ";

class GestionPersonnel extends Component {

    constructor(props) {
        super(props);
        this.state = {
          nbCa:0,
          nbRtt:0,
          nbRc:0,
          types: []
      }
    }

  componentDidMount() {
       axios.get('http://localhost:8080/emp/getEmploye?nom='+nom)
          .then(res => {
              this.setState({
                nom: res.data[0].nomResp,
                prenom: res.data[0].prenomResp,
                nbCa: res.data[0].nbCa,
                nbRtt: res.data[0].nbRtt,
                nbRc: res.data[0].nbRc
            });
      });

    axios.get('http://localhost:8080/type/listeTypeAbsence')
       .then(res => {
           this.setState({
             types: res.data
         });
   });
}

  render() {
    return (
      <div>
        <div className="voffsetpos">&nbsp;</div>   {/*1   Cosmétique Ajout d'une marge au dessus du formulaire réglable via le css voffsetpos */}{/*1    fin */}
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de Formulaire */}
            <h3 className="panel-title">Gestion du personnel</h3>                 {/* Factice Pour rectifier bug d'affichage sur Atom */}
          </div>   {/*3   fin */}
          <div className="panel-body">   {/*4   Contenu Formulaire */}
            <div className="voffsethaut">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css voffsethaut */}{/*5   fin */}
            <div className="row">
              <div className="col-md-4 col-md-offset-1">   {/*6   Formulaire Partie gauche */}
                <div className="form-group">   {/*7   Un des champs select du Formulaire */}
                  <label>Nom de l'employé</label>                                       {/*'*/}
                  <input className="form-control" placeholder="Nom de l'employé" />
                </div>   {/*7   fin */}
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
              </div>   {/*6   fin */}
              <div className="col-md-4">   {/*8   Block formulaire Partie droite */}
                <div className="form-group">
                  <label>Equipe</label>                                           {/*'*/}
                  <select className="form-control">
                      <option>Liste équipes</option>
                  </select>
                </div>
                <div className="form-group">
                  <label>Responsable</label>                                           {/*'*/}
                  <select className="form-control">
                      <option>Liste responsables</option>
                  </select>
                </div>
                <div className="form-group">
                  <label>Backup</label>                                           {/*'*/}
                  <select className="form-control">
                      <option>Liste backups</option>
                  </select>
                </div>
                <div className="form-group">
                  <label>Service RH</label>                                           {/*'*/}
                  <select className="form-control">
                      <option>Liste services RH</option>
                  </select>
                </div>
              </div>   {/*8   fin */}
              <div className="col-md-2">
                <div className="form-group ">
                  <div className="panel panel-default">
                    <div className="panel-heading">   {/*3   Titre de Formulaire */}
                      <h3 className="panel-title">Droits d'accès</h3>                 {/* Factice Pour rectifier bug d'affichage sur Atom */}
                    </div>   {/*3   fin */}
                    <div className="panel-body">   {/*4   Contenu Formulaire */}
                      <div className="vdecalage4">&nbsp;</div>
                      <div className="checkbox">
                        <label>&nbsp;&nbsp;
                          <input type="checkbox" value=""/>Valideur
                        </label>
                      </div>
                      <div className="vdecalage4">&nbsp;</div>
                      <div className="checkbox">
                        <label>&nbsp;&nbsp;
                          <input type="checkbox" value=""/>Valideur RH
                        </label>
                      </div>
                      <div className="vdecalage4">&nbsp;</div>
                      <div className="checkbox">
                        <label>&nbsp;&nbsp;
                          <input type="checkbox" value=""/>Administrateur
                        </label>
                      </div>
                    </div>
                  </div>
                </div>
                <div className="vdecalage5">&nbsp;</div>
                <div className="form-group">
                  <div className="vdecalage4">
                    <a href="index.html" className="btn btn-primary btn-md btn-block">Réinitialisation<br/>du mot de passe</a>
                  </div>
                </div>
              </div>
            </div>
            <div className="row">   {/*11   Block Boutons Soumettre et Annuler */}
              <div className="voffsetbas">&nbsp;</div>   {/*12   Cosmétique d'unee marge au dessus des boutons */}{/*12   fin */}
              <div className="col-md-10 col-md-offset-1">
                <div className="col-md-2 col-md-offset-4">
                  <a href="index.html" className="btn btn-primary btn-block">Précédent</a>
                </div>
                <div className="col-md-2">
                  <a href="index.html" className="btn btn-primary btn-block">Suivant</a>
                </div>
              </div>
            </div>
            <div className="row">   {/*11   Block Boutons Soumettre et Annuler */}
              <div className="voffsetbas">&nbsp;</div>   {/*12   Cosmétique d'unee marge au dessus des boutons */}{/*12   fin */}
              <div className="col-md-10 col-md-offset-1">
                <div className="col-md-3">
                  <a href="index.html" className="btn btn-primary btn-block">Nouveau</a>
                </div>
                <div className="col-md-3">
                  <a href="index.html" className="btn btn-primary btn-block">Supprimer</a>
                </div>
                <div className="col-md-3">
                  <a href="index.html" className="btn btn-primary btn-block">Enregistrer</a>
                </div>
                <div className="col-md-3">
                  <a href="index.html" className="btn btn-primary btn-block">Annuler</a>
                </div>
              </div>
            </div>
          </div>   {/*4   fin */}
          <div className="voffsetbas">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css voffsetbas */}   {/*13   fin */}
        </div>   {/*2   fin */}
      </div>
    );
  }
}

export default GestionPersonnel;
