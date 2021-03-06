import React, { Component } from 'react';

import './avisrh.css';

class AvisRh extends Component {

      constructor(props) {
          super(props);
          this.props = props;
      }

  render() {
    return (
      <div>
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de Formulaire */}
            <h3 className="panel-title">Avis Rh</h3>
          </div>   {/*3   fin */}
          <div className="panel-body">   {/*4   Contenu Formulaire */}
            <div className="VOffSetHautPages">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css VOffSetHautPages */}{/*5   fin */}
            <div className="row">
              <div className="col-md-4 col-md-offset-1">   {/*6   Formulaire Partie gauche */}
                <div className="form-group">
                  <label>Nom de l'employé</label>{/*'*/}
                  <label className="form-control"></label>
                </div>
                <div className="form-group">
                  <label>Prénom de l'employé</label>{/*'*/}
                  <label className="form-control"></label>
                </div>
                <div className="form-group">
                  <label>Type</label>
                  <label className="form-control"></label>
                </div>
                <div className="form-group">
                  <label>Date du début</label>
                  <label className="form-control"></label>
                </div>
                <div className="form-group">
                  <label>Date de fin</label>
                  <label className="form-control"></label>
                </div>
              </div>
              <div className="col-md-4 col-md-offset-2">   {/*8   Block formulaire Partie droite */}
                <div className="VOffSetAvis">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css VOffSetHautPages */}{/*5   fin */}
				        <div className="form-group input-group">
            		  <span className="input-group-addon"><label className="VOffSetAvis3">Décision</label></span>
                  <div className="radio-inline mefradio input-group-addon">
                    <div className="mefinput">
                  	  <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline1" value="option1"/>Valider
                    </div>
                  </div>
                  <div className="radio-inline mefradio input-group-addon">
                    <div className="mefinput">
                    	<input type="radio" name="optionsRadiosInline" id="optionsRadiosInline2" value="option2"/>Refuser
                    </div>
                  </div>
                </div>
                <div className="VOffSetAvis">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css VOffSetHautPages */}{/*5   fin */}
                <div className="form-group">   {/*10   Champs de saisie de type Zone de texte */}
                	<label>Commentaires</label>
                  <textarea rows="7" className="form-control"></textarea>
                </div>   {/*10   fin */}
                <div className="VOffSetAvis2">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css VOffSetHautPages */}{/*5   fin */}
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
            </div>
            <div className="row">   {/*11   Block Boutons Soumettre et Annuler */}
              <div className="VOffSetBasPages">&nbsp;</div>   {/*12   Cosmétique d'unee marge au dessus des boutons */}{/*12   fin */}
              <div className="col-md-2 col-md-offset-4 btn-bottom-marge">
                <a href="index.html" className="btn btn-primary btn-block">Soumettre</a>
              </div>
              <div className="col-md-2 btn-bottom-marge">
                <a href="index.html" className="btn btn-primary btn-block">Annuler</a>
              </div>
            </div>   {/*11   fin */}
          </div>   {/*4   fin */}
          <div className="VOffSetBasPages">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
        </div>   {/*2   fin */}
        <div className="VOffSetBasPages">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
      </div>
    );
  }
}

export default AvisRh;
