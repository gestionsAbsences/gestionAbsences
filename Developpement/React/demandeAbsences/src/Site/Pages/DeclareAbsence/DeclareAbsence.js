import React, { Component } from 'react';

import axios from 'axios';

import './declareabsence.css';

class DeclareAbsence extends Component {

  constructor(props) {
    super(props);
    this.props = props;
    this.state = {
      types: []
    }
  }

  componentDidMount() {
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
                  <input className="form-control" placeholder="Nom de l'employé" />
                </div>   {/*7   fin */}
                <div className="form-group">
                  <label>Prénom de l'employé</label>                                     {/*'*/}
                  <input className="form-control" placeholder="Prénom de l'employé" />
                </div>
                <div className="form-group">
                  <label>Type d'absence</label>                                           {/*'*/}
                  <select className="form-control">
                    {this.state.types.map(
                      (type, i) =>
                      <option key={i}>{type.nom}</option>
                    )}
                  </select>
                </div>
                <div className="VOffSetDecla">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css VOffSetHautPages */}{/*5   fin */}
                <div className="container-fluid">   {/*7   Les 3 labels pour les compteurs */}
                  <div className="text-center ajust">
                    <div className="form-group col-md-4">
                      <label className="form-control">{/*nbCa*/} CP</label>
                    </div>
                    <div className="form-group col-md-4">
                      <label className="form-control">{/*nbRtt*/} RTT</label>
                    </div>
                    <div className="form-group col-md-4">
                      <label className="form-control">{/*nbRc*/} RC</label>
                    </div>
                  </div>
                </div>   {/*7   fin */}
              </div>   {/*6   fin */}
              <div className="col-md-4 col-md-offset-2">   {/*8   Block formulaire Partie droite */}
                <div className="form-group">   {/*9   Un des champ de saisie de type texte */}
                  <label>Date de début</label>
                  <input type="date" className="form-control" placeholder="Fin" />
                </div>   {/*9   fin */}
                <div className="form-group">
                  <label>Date de fin</label>
                  <input type="date" className="form-control" placeholder="Fin" />
                </div>
                <div className="form-group">   {/*10   Champs de saisie de type Zone de texte */}
                  <label>Commentaires</label>
                  <textarea rows="7" className="form-control"></textarea>
                </div>   {/*10   fin */}
              </div>   {/*8   fin */}
              <div className="col-md-1"></div>
            </div>
            <div className="row">   {/*11   Block Boutons Soumettre et Annuler */}
              <div className="VOffSetBasPages">&nbsp;</div>   {/*12   Cosmétique d'unee marge au dessus des boutons */}{/*12   fin */}
              <div className="col-md-2 col-md-offset-4">
                <a href="index.html" className="btn btn-primary btn-block">Soumettre</a>
              </div>
              <div className="col-md-2">
                <a href="index.html" className="btn btn-primary btn-block">Annuler</a>
              </div>
            </div>   {/*11   fin */}
          </div>   {/*4   fin */}
          <div className="VOffSetBasPages">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
        </div>   {/*2   fin */}
      </div>
    );
  }
}

export default DeclareAbsence;
