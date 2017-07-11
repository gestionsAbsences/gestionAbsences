<?php /** Ouverture session **********************************************************************************************************************/
session_start();
?>
<?php /** Fonctions ******************************************************************************************************************************/
function fMailGestCorp($Cas) {
  $Corp = '';
  $to   = '';
  $cc   = '';
  $PJ   = '';
  if ($Cas ==  1) { /** Mail Accusé de réception de la demande - Dest=Bénéficiaire ***************************************************************/
      $Corp="<p>Nous accusons réception de votre demande d'obtention des droits d'administrateur sur votre poste de travail sous le N°&nbsp;<a href=\"".$GLOBALS['URL']."?Page=".fCodecodage('11'.$GLOBALS['NoDemande'])."\">".$GLOBALS['NoDemande']."</a>.</p><p>Votre demande va être étudiée et vous serez très prochainement informé(e) de la décision retenue.</p>";
      $to=$GLOBALS['MelUser'];}
  if ($Cas ==  2) { /** Mail+Lien pour validation - Dest=Responsable de pôle *********************************************************************/
      $Corp="<p>L'utilisateur(trice) ".$GLOBALS['User']." dont vous êtes le ou la responsable de pôle, demande à bénéficier des droits d'administrateur sur son poste de travail.</p><p>En qualité de responsable de pôle, merci de bien vouloir étudier la demande référencée sous le N°&nbsp;<a href=\"".$GLOBALS['URL']."?Page=".fCodecodage('12'.$GLOBALS['NoDemande'])."\">".$GLOBALS['NoDemande']."</a> et d'y apporter votre validation ou votre refus <span style='color:#1F497D'><b>en cliquant sur le lien</b></span>.</p><p>Nous attirons votre vigilance sur l'importance et votre engagement concernant votre validation ou votre refus.</p><p style='color:#1F497D'><b>Une ultime étape est prévue pour la signature de la Charte. Elle est obligatoire pour que la demande soit traitée par le CDS.</b></p>";
      $to=$GLOBALS['MelResp'];}
  if ($Cas == 22) { /** Mail+Lien pour validation - Dest=Responsable de pôle *********************************************************************/
      $Corp="<p>L'utilisateur(trice) ".$GLOBALS['User']." dont vous êtes le ou la responsable de pôle, demande à bénéficier des droits d'administrateur sur son poste de travail.</p><p>En qualité de responsable de pôle, merci de bien vouloir étudier la demande référencée sous le N°&nbsp;<a href=\"".$GLOBALS['URL']."?Page=".fCodecodage('42'.$GLOBALS['NoDemande'])."\">".$GLOBALS['NoDemande']."</a> et d'y apporter votre validation ou votre refus <span style='color:#1F497D'><b>en cliquant sur le lien</b></span>.</p><p>Nous attirons votre vigilance sur l'importance et votre engagement concernant votre validation ou votre refus.</p><p style='color:#1F497D'></p>";
      $to=$GLOBALS['MelResp'];}
  if ($Cas ==  3) { /** Mail Refus du Responsable de pôle - Dest=Bénéficiaire+Responsable de pôle ************************************************/
      $Corp="<p>Votre demande N°&nbsp;".$GLOBALS['NoDemande']." pour l'obtention des droits d'administrateur sur votre poste de travail n'a pas été approuvée par votre responsable de pôle pour les motifs ci-dessous.</p><p style=\"background-color:#D9D9D9\">Motif : ".nl2br($GLOBALS['CommentResp'])."</p><p>En conséquence votre demande est annulée.</p>";
      $to=$GLOBALS['MelUser'];
      $cc=$GLOBALS['MelResp'];}
  if ($Cas ==  4) { /** Mail Accord du Responsable de pôle - Dest=Bénéficiaire+Responsable de pôle ***********************************************/
      $Corp="<p>Votre responsable de pôle vient de valider votre demande pour l'obtention des droits d'administrateur sur votre poste de travail.</p><p>Votre demande va être soumise au service d'attribution de droits d'administration pour étude et prise de décision.</p><p>Vous serez très prochainement informé(e) par mail de la décision retenue par le service d'attribution des droits d'administration.</p>";
      $to=$GLOBALS['MelUser'];
      $cc=$GLOBALS['MelResp'];}
  if ($Cas ==  5) { /** Mail+Lien pour validation - Dest=Expert technique+Backup *****************************************************************/
      fBDDExtrairePDOSite(" WHERE SiteSB='".$GLOBALS['SiteUser']."'");
      $Corp="<p>En qualité d'expert technique, merci de bien vouloir étudier l'opportunité de la demande&nbsp;<a href=\"".$GLOBALS['URL']."?Page=".fCodecodage('13'.$GLOBALS['NoDemande'])."\">".$GLOBALS['NoDemande']."</a> d'obtention des droits d'administrateur sur le poste de travail de l'utilisateur ".$GLOBALS['User'].".</p><p>Afin de vous prononcer merci de cliquer sur le N° de la demande ci-dessus.</p>";
      $to=$GLOBALS['MelSB'];
      $cc=$GLOBALS['MelSB2'];}
  if ($Cas ==  25) { /** Mail+Lien pour validation - Dest=Expert technique+Backup *****************************************************************/
      fBDDExtrairePDOSite(" WHERE SiteSB='".$GLOBALS['SiteUser']."'");
      $Corp="<p>En qualité d'expert technique, merci de bien vouloir étudier l'opportunité de la demande&nbsp;<a href=\"".$GLOBALS['URL']."?Page=".fCodecodage('43'.$GLOBALS['NoDemande'])."\">".$GLOBALS['NoDemande']."</a> d'obtention des droits d'administrateur sur le poste de travail de l'utilisateur ".$GLOBALS['User'].".</p><p>Afin de vous prononcer merci de cliquer sur le N° de la demande ci-dessus.</p>";
      $to=$GLOBALS['MelSB'];
      $cc=$GLOBALS['MelSB2'];}
  if ($Cas ==  14) { /** Mail+Lien pour validation - Dest=Responsable technique ******************************************************************/
      fBDDExtrairePDOSite(" WHERE SiteSB='".$GLOBALS['SiteUser']."'");
      $Corp="<p>En qualité de responsable technique, merci de bien vouloir étudier l'opportunité de la demande&nbsp;<a href=\"".$GLOBALS['URL']."?Page=".fCodecodage('14'.$GLOBALS['NoDemande'])."\">".$GLOBALS['NoDemande']."</a> d'obtention des droits d'administrateur sur le poste de travail de l'utilisateur ".$GLOBALS['User'].".</p><p>Afin de vous prononcer merci de cliquer sur le N° de la demande ci-dessus.</p>";
      $to=$GLOBALS['MelLitige'];}
  if ($Cas ==  15) { /** Mail+Lien pour validation - Dest=Responsable technique ******************************************************************/
      fBDDExtrairePDOSite(" WHERE SiteSB='".$GLOBALS['SiteUser']."'");
      $Corp="<p>En qualité de responsable technique, merci de bien vouloir étudier l'opportunité de la demande&nbsp;<a href=\"".$GLOBALS['URL']."?Page=".fCodecodage('44'.$GLOBALS['NoDemande'])."\">".$GLOBALS['NoDemande']."</a> d'obtention des droits d'administrateur sur le poste de travail de l'utilisateur ".$GLOBALS['User'].".</p><p>Afin de vous prononcer merci de cliquer sur le N° de la demande ci-dessus.</p>";
      $to=$GLOBALS['MelLitige'];}
  if ($Cas ==  6) { /** Mail+Lien pour Charte - Dest=Responsable de pôle *************************************************************************/
      $Corp="<p>Afin de finaliser la demande, merci de signer numériquement la Charte d'administration en cliquant sur le N° de la demande : N°&nbsp;<a href=\"".$GLOBALS['URL']."?Page=".fCodecodage('21'.$GLOBALS['NoDemande'])."\">".$GLOBALS['NoDemande']."</a>.</p>";
      $to=$GLOBALS['MelResp'];}
  if ($Cas ==  7) { /** Mail+Lien pour Charte - Dest=Bénéficiaire ********************************************************************************/
      $Corp="<p>Afin de finaliser la demande, merci de signer numériquement la Charte d'administration en cliquant sur le N° de la demande : N°&nbsp;<a href=\"".$GLOBALS['URL']."?Page=".fCodecodage('22'.$GLOBALS['NoDemande'])."\">".$GLOBALS['NoDemande']."</a>.</p>";
      $to=$GLOBALS['MelUser'];}
  if ($Cas ==  8) { /** Mail Refus du RSSI - Dest=Bénéficiaire+Responsable de pôle ***************************************************************/
      $Corp="<p>Votre demande N°&nbsp;".$GLOBALS['NoDemande']." pour l'obtention des  droits d'administrateur sur votre poste de travail n'a pas été approuvée par le service d'attribution des droits d'administration pour les motifs ci-dessous.</p><p style=\"background-color:#D9D9D9\">Motif : ".nl2br($GLOBALS['CommentValideur'])."</p><p>En conséquence votre demande est annulée.</p>";
      $to=$GLOBALS['MelUser'];
      $cc=$GLOBALS['MelResp'];}
  if ($Cas ==  9) { /** Mail Chartes signées - Dest=CDS ******************************************************************************************/
      fBDDExtrairePDOParam();
      $Corp="<p>Merci de bien vouloir attribuer les droits d'administration sur le poste de travail de l'utilisateur(trice) identifié(e) dans la fiche ci-dessous.</p>".fMailElementDonnees().fMailElementDonnees('Demande N°',$GLOBALS['NoDemande']).fMailElementDonnees().fMailElementTitre('IDENTIFICATION DU BENEFICIAIRE').fMailElementDonnees('NOM Prénom',$GLOBALS['User']).fMailElementDonnees('Identifiant RH',$GLOBALS['IdRH']).fMailElementDonnees('Adresse mail',$GLOBALS['MelUser']).fMailElementDonnees('Téléphone',$GLOBALS['TelUser']).fMailElementDonnees('Direction',$GLOBALS['DirUser']).fMailElementDonnees('Site',$GLOBALS['SiteUser']).fMailElementDonnees('Netbios',$GLOBALS['Machine'])."<br><p>Merci également de créer une tâche pour le centre serveurs afin d’enlever de la GPO le(s) poste(s) de travail concerné(s).</p><br>";
      $to=$GLOBALS['MelCDS'];}
  if ($Cas == 10) { /** Mail Chartes signées - Dest=Bénéficiaire *********************************************************************************/
      $Corp="<p>Votre demande d'obtention des droits d'administrateur a été validée, vous allez très prochainement être contacté(e) par les services Support Informatique afin de procéder à la mise en place des droits d'administrateur sur votre poste de travail.</p>";
      $to=$GLOBALS['MelUser'];}
  if ($Cas == 11) { /** Mail Refus de l'Expert technique - Dest=Bénéficiaire+Responsable de pôle *************************************************/
      $Corp="<p>Votre demande N°&nbsp;".$GLOBALS['NoDemande']." pour l'obtention des droits d'administrateur sur votre poste de travail n'a pas été approuvée par le service d'attribution des droits d'administration pour les motifs ci-dessous.</p><p style=\"background-color:#D9D9D9\">Motif : ".nl2br($GLOBALS['CommentSB'])."</p><p>En conséquence votre demande est annulée.</p>";
      $to=$GLOBALS['MelUser'];
      $cc=$GLOBALS['MelResp'];}
  if ($Cas == 21) { /** Mail Refus du Responsable technique - Dest=Bénéficiaire+Responsable de pôle **********************************************/
      $Corp="<p>Votre demande N°&nbsp;".$GLOBALS['NoDemande']." pour l'obtention des droits d'administrateur sur votre poste de travail n'a pas été approuvée par le service d'attribution des droits d'administration pour les motifs ci-dessous.</p><p style=\"background-color:#D9D9D9\">Motif : ".nl2br($GLOBALS['CommentLitige'])."</p><p>En conséquence votre demande est annulée.</p>";
      $to=$GLOBALS['MelUser'];
      $cc=$GLOBALS['MelResp'];}
  if ($Cas == 12) { /** Mail+Lien pour validation - Dest=RSSI ************************************************************************************/
      fBDDExtrairePDOParam();
      $Corp="<p>Merci de bien vouloir étudier la demande&nbsp;<a href=\"".$GLOBALS['URL']."?Page=".fCodecodage('15'.$GLOBALS['NoDemande'])."\">".$GLOBALS['NoDemande']."</a> d'obtention des droits d'administrateur sur le poste de travail de l'utilisateur(trice) ".$GLOBALS['User'].".</p><p>Afin de vous prononcer merci de cliquer sur le N° de la demande ci-dessus.</p>";
      $to=$GLOBALS['MelValideur'];}
  if ($Cas == 32) { /** Mail+Lien pour validation - Dest=RSSI ************************************************************************************/
      fBDDExtrairePDOParam();
      $Corp="<p>Merci de bien vouloir étudier la demande&nbsp;<a href=\"".$GLOBALS['URL']."?Page=".fCodecodage('45'.$GLOBALS['NoDemande'])."\">".$GLOBALS['NoDemande']."</a> d'obtention des droits d'administrateur sur le poste de travail de l'utilisateur(trice) ".$GLOBALS['User'].".</p><p>Afin de vous prononcer merci de cliquer sur le N° de la demande ci-dessus.</p>";
      $to=$GLOBALS['MelValideur'];}
  if ($Cas == 13) { /** Mail Chartes signées, Récépissé - Dest=Bénéficiaire+Responsable de pôle **************************************************/
      fBDDExtrairePDOParam();
      $Lien="";
      $Lien=$GLOBALS['URL']."telecharge.php";
      $Corp="<p>Votre engagement numérique de la charte concernant votre demande N° ".$GLOBALS['NoDemande']." de droits d’administration a bien été prise en compte.</p><p>Pour rappel, le BRH applicable à ce type de profil : <a href=\"".$GLOBALS['LienBRH']."\" target=\"_blank\">Charte de Sécurité des administrateurs informatiques</a>.</p><p></p><p></p><hr><tr><td><p>ENGAGEMENT PERSONNEL DE L'AGENT</p></td></tr><tr><td><p>Je soussigné, ".$GLOBALS['User'].", déclare avoir pris connaissance et compris la <b>« Charte de Sécurité des administrateurs informatiques »</b> et m'engage à la respecter.<br></p><p>Fait à ".$GLOBALS['SiteCharteUser'].", le ".Date("d/m/Y").".</p><p></p><p>Signé numériquement.</p></td></tr><hr><tr><td><p>ENGAGEMENT DU RESPONSABLE HIERARCHIQUE</p></td></tr><tr><td><p>Je soussigné, ".$GLOBALS['Resp']." agissant en tant que responsable de pôle de ".$GLOBALS['User'].", déclare avoir pris connaissance et compris la <b>« Charte de Sécurité des administrateurs informatiques »</b> et m'engage à en respecter les limites définies.<br></p><p>Fait à ".$GLOBALS['SiteCharteResp'].", le ".Date("d/m/Y").".</p><p></p><p>Signé numériquement.</p></td></tr><hr>";
      //<p><a href=\"".$Lien."\">Cliquez ici pour télécharger un exemplaire de la charte d'administrateur</a></p>
	  $to=$GLOBALS['MelUser'].','.$GLOBALS['MelResp'];
      $cc=$GLOBALS['MelValideur'];}
  fBDDExtrairePDOParam();
  // sujet du mail
  $Sujet    = "Demande d'obtention des droits d'administrateur N° ".$GLOBALS['NoDemande'];
  $texte  = "";
  $attachement  = "";
  // Les headers pour un mail multiparts
  $headers= "MIME-Version: 1.0\n";
  $headers .= 'To: '.$to. "\n";
  $headers .= 'From: '.$GLOBALS['Valideur'].' <'.$GLOBALS['MelValideur'].'>' . "\n";
  if ($cc!='') {$headers .= 'Cc: '.$cc."\n";}
  $headers.= "Content-type: multipart/mixed;\n";
  // Chaine permettant de différencier les différentes parties du mail
  $limite = '_parties_'.md5(uniqid (rand()));
  $headers.= " boundary=\"----=$limite\"\n\n";

  // Première partie, corps du mail en HTML
  $texte = "------=$limite\n";
  $texte.= "Content-type: text/html; charset=\"iso-8859-1\"\n\n";
  $texte.="
    <html>
      <head>
        <title>".$Sujet."</title>
      </head>";
/*	  
      <style type=\"text/css\" media=\"screen\">
        tr {border-width: 1px; border-color: black;}
        td {border-bottom: 1px solid #555; border-left: 1px solid #FFF; border-right: 1px solid #555; border-top: 1px solid #FFF; padding-left: 5px;}
        p  {font-family: calibri; color: black;font-size: 15px;}
      </style>    
*/
  $texte.="
      <body>
        <p>&nbsp;</p>
        <p>&nbsp;Bonjour,</p><br>".
        $Corp."<br>
        <p>Cordialement,<br>
        ".$GLOBALS['Valideur'].".</p>
        <p style=\"font-size: 11px;color: red;\">Ce message vous a été envoyé automatiquement, merci de ne pas répondre.</p>
      </body>
    </html>
    ";
  if ($PJ!="") {
    // Traitement pour attacher une PJ
    // D'abord on lit le fichier
    $contenu = file_get_contents($PJ);
    $attachement = "\n------=$limite\n";
    // Dans mon exemple, il s'agit d'un fichier html, il faut mettre le bon mime type
    $attachement .= "Content-Type: text/html; name=\"$PJ\"\n";
    $attachement .= "Content-Transfer-Encoding: base64\n";
    $attachement .= "Content-Disposition: attachment; filename=\"$PJ\"\n\n";
    // Ca y est on joint le fichier en l'encodant en base 64
    $attachement .= chunk_split(base64_encode($contenu));
    }

  //  enfin on envoi le mail
  mail($to, $Sujet, $texte.$attachement, $headers);
  return;
}
function fMailElementTitre($Label) {
  $v = '
        <p>'.$Label.'</p>';
  return $v;
  }
function fMailElementDonnees($Label='',$Valeur='') {
  $v = '<br>';
  if ($Label=='') {return $v;}
  if ($Valeur=='') {return $v;}
  $v = '
        <p>&nbsp;&nbsp;'.$Label.'&nbsp;&nbsp;:&nbsp;&nbsp;'.$Valeur.'</p>';
  return $v;
  }
Function fBDDModifPDO($Champs,$Donnees,$Cond='') {
/**************************************************************************************************************************************************/
//$Champs = "NOMPrenom/IdRH/TelUser";
//$Donnees = $NOMPrenom.'/'.$IdRH.'/'.$TelUser;
//$Cond = " WHERE NOMPrenom = ".$NOMPrenom;
/**************************************************************************************************************************************************/
// configuration
//$dBType    = "sqlite";

// database connection
$Conn = new PDO("mysql:host=".$GLOBALS['dbHost'].";dbname=".$GLOBALS['dBName'],$GLOBALS['dBUser'],$GLOBALS['dBPass']);

$Champs=fConvChaine($Champs, "=?,")."=?";

// query
$Sql = "UPDATE ".$GLOBALS['dBDonnees']." SET ".$Champs.$Cond;
$Qry = $Conn->prepare($Sql);
$Qry->execute($Donnees);
}
function fBDDExtrairePDODonnees($Cond='') {
/**************************************************************************************************************************************************/
//$Cond = " WHERE NOMPrenom = ".$NOMPrenom;
/**************************************************************************************************************************************************/
  $bdd = new PDO("mysql:host=".$GLOBALS['dbHost'].";dbname=".$GLOBALS['dBName'],$GLOBALS['dBUser'],$GLOBALS['dBPass']);
  try {$bdd = new PDO("mysql:host=".$GLOBALS['dbHost'].";dbname=".$GLOBALS['dBName'],$GLOBALS['dBUser'],$GLOBALS['dBPass']);}
  catch(Exception $e) {die();} // {die('Erreur : '.$e->getMessage());}
  $reponse = $bdd->query('SELECT * FROM '.$GLOBALS['dBDonnees'].$Cond);
// On affiche chaque entrée une à une
  while ($donnees = $reponse->fetch()) {
    $GLOBALS['No']               = $donnees['No'];
    $GLOBALS['NoDemande']        = 'DEM'.substr(strval(1000000+$GLOBALS['No']),-6);
    $GLOBALS['User']             = $donnees['User'];
    $GLOBALS['IdRH']             = $donnees['IdRH'];
    $GLOBALS['MelUser']          = $donnees['MelUser'];
    $GLOBALS['TelUser']          = $donnees['TelUser'];
    $GLOBALS['DirUser']          = $donnees['DirUser'];
    $GLOBALS['SiteUser']         = $donnees['SiteUser'];
    $GLOBALS['MotifUser']        = $donnees['MotifUser'];
    $GLOBALS['Netbios']          = $donnees['Netbios'];
    $GLOBALS['Machine']          = $donnees['Machine'];
    $GLOBALS['DateUser']         = $donnees['DateUser'];
    $GLOBALS['Resp']             = $donnees['Resp'];
    $GLOBALS['IdRHResp']         = $donnees['IdRHResp'];
    $GLOBALS['MelResp']          = $donnees['MelResp'];
    $GLOBALS['TelResp']          = $donnees['TelResp'];
    $GLOBALS['AccordResp']       = $donnees['AccordResp'];
    $GLOBALS['CommentResp']      = $donnees['CommentResp'];
    $GLOBALS['DateResp']         = $donnees['DateResp'];
    $GLOBALS['AccordSB']         = $donnees['AccordSB'];
    $GLOBALS['CommentSB']        = $donnees['CommentSB'];
    $GLOBALS['DateSB']           = $donnees['DateSB'];
    $GLOBALS['AccordLitige']     = $donnees['AccordLitige'];
    $GLOBALS['CommentLitige']    = $donnees['CommentLitige'];
    $GLOBALS['DateLitige']       = $donnees['DateLitige'];
    $GLOBALS['AccordValideur']   = $donnees['AccordValideur'];
    $GLOBALS['CommentValideur']  = $donnees['CommentValideur'];
    $GLOBALS['DateValideur']     = $donnees['DateValideur'];
    $GLOBALS['CharteUser']       = $donnees['CharteUser'];
    $GLOBALS['SiteCharteUser']   = $donnees['SiteCharteUser'];
    if ($GLOBALS['SiteCharteUser']=="") {$GLOBALS['SiteCharteUser'] = $GLOBALS['SiteUser'];}
    $GLOBALS['DateCharteUser']   = $donnees['DateCharteUser'];
    $GLOBALS['CharteResp']       = $donnees['CharteResp'];
    $GLOBALS['SiteCharteResp']   = $donnees['SiteCharteResp'];
    if ($GLOBALS['SiteCharteResp']=="") {$GLOBALS['SiteCharteResp'] = $GLOBALS['SiteUser'];}
    $GLOBALS['DateCharteResp']   = $donnees['DateCharteResp'];
    $GLOBALS['DateCDS']          = $donnees['DateCDS'];
    $GLOBALS['Statut']           = $donnees['Statut'];
    $GLOBALS['SB']               = $donnees['SB'];
    $GLOBALS['IdRHSB']           = $donnees['IdRHSB'];
    $GLOBALS['MelSB']            = $donnees['MelSB'];
    $GLOBALS['SB2']              = $donnees['SB2'];
    $GLOBALS['IdRHSB2']          = $donnees['IdRHSB2'];
    $GLOBALS['MelSB2']           = $donnees['MelSB2'];
    $reponse->closeCursor(); // Termine le traitement de la requête
  }
  return true;
}
function fBDDExtrairePDOParam($Cond='') {
/**************************************************************************************************************************************************/
//$Cond = " WHERE No = ".$No;
/**************************************************************************************************************************************************/
  $bdd = new PDO("mysql:host=".$GLOBALS['dbHost'].";dbname=".$GLOBALS['dBName'],$GLOBALS['dBUser'],$GLOBALS['dBPass']);
  try {$bdd = new PDO("mysql:host=".$GLOBALS['dbHost'].";dbname=".$GLOBALS['dBName'],$GLOBALS['dBUser'],$GLOBALS['dBPass']);}
  catch(Exception $e) {die();} // {die('Erreur : '.$e->getMessage());}
  $reponse = $bdd->query('SELECT * FROM '.$GLOBALS['dBParam'].$Cond);
// On affiche chaque entrée une à une
  while ($param = $reponse->fetch()) {
    $GLOBALS['Valideur']             = $param['Valideur'];
    $GLOBALS['MelValideur']          = $param['MelValideur'];
    $GLOBALS['MelCDS']               = $param['MelCDS'];
    $GLOBALS['MelLitige']            = $param['MelLitige'];
    $reponse->closeCursor(); // Termine le traitement de la requête
  }
  return true;
}
function fBDDExtrairePDOSite($Cond='') {
/**************************************************************************************************************************************************/
//$Cond = " WHERE Site = ".$SiteUser;
/**************************************************************************************************************************************************/
  $bdd = new PDO("mysql:host=".$GLOBALS['dbHost'].";dbname=".$GLOBALS['dBName'],$GLOBALS['dBUser'],$GLOBALS['dBPass']);
  try {$bdd = new PDO("mysql:host=".$GLOBALS['dbHost'].";dbname=".$GLOBALS['dBName'],$GLOBALS['dBUser'],$GLOBALS['dBPass']);}
  catch(Exception $e) {die();}
  $reponse = $bdd->query('SELECT * FROM '.$GLOBALS['dBSite'].$Cond);
// On affiche chaque entrée une à une
  while ($site = $reponse->fetch()) {
    $GLOBALS['SiteSB']               = $site['SiteSB'];
    $GLOBALS['AbregeSB']             = $site['AbregeSB'];
    $GLOBALS['RespSB']               = $site['RespSB'];
    $GLOBALS['IdRHSB']               = $site['IdRHSB'];
    $GLOBALS['MelSB']                = $site['MelSB'];
    $GLOBALS['TelSB']                = $site['TelSB'];
    $GLOBALS['RespSB2']              = $site['RespSB2'];
    $GLOBALS['IdRHSB2']              = $site['IdRHSB2'];
    $GLOBALS['MelSB2']               = $site['MelSB2'];
    $GLOBALS['TelSB2']               = $site['TelSB2'];
    $reponse->closeCursor(); // Termine le traitement de la requête
  }
  return true;
}
function fBDDExtrairePDOSiteArray() {
/**************************************************************************************************************************************************/
//$Cond = " WHERE Site = ".$SiteUser;
/**************************************************************************************************************************************************/
  $bdd = new PDO("mysql:host=".$GLOBALS['dbHost'].";dbname=".$GLOBALS['dBName'],$GLOBALS['dBUser'],$GLOBALS['dBPass']);
  try {$bdd = new PDO("mysql:host=".$GLOBALS['dbHost'].";dbname=".$GLOBALS['dBName'],$GLOBALS['dBUser'],$GLOBALS['dBPass']);}
  catch(Exception $e) {die();} // {die('Erreur : '.$e->getMessage());}
  //$reponse = $bdd->query('SELECT * FROM '.$GLOBALS['dBSite']." WHERE AbregeSB<>'CHP' AND AbregeSB<>'EIF'");
  $reponse = $bdd->query('SELECT * FROM '.$GLOBALS['dBSite'].' ORDER BY SiteSB');
  $Dlm="";
  $Result="";
// On affiche chaque entrée une à une
  while ($site = $reponse->fetch()) {
		$Result.= $Dlm.$site['SiteSB'];
    $Dlm=",";
  }
  $reponse->closeCursor(); // Termine le traitement de la requête
  return $Result;
}
function fAfficheLigne() {
  echo '
          <tr>
            <td class="width1 hauteur3">&nbsp;</td>
            <td class="width2 hauteur3">&nbsp;</td>
            <td class="width3 hauteur3">&nbsp;</td>
          </tr>';
  return;
  }
function fAfficheTitre($Label){
  echo '
          <tr>
            <td class="bandeau cadre1" colspan=3>'.$Label.'</td>
          </tr>';
  return;
  }
function fAfficheEnTete($Label) {
  echo '
          <tr>
            <td class="rubriques couleur2 hauteur4 cadre1" colspan=3>'.$Label.'</td>
          </tr>';
  return;
  }
function fAfficheInfo($Label,$NomObj,$Valeur) {
  echo '
          <tr>
            <td class="couleur2 hauteur2 cadre1">&nbsp;&nbsp;'.$Label.'</td>
            <td colspan=2 class="cadre1" style="padding-left:4px;">
              <input type="text" name="'.$NomObj.'" value="'.$Valeur.'" disabled="disabled" class="width4"></input>
            </td>
          </tr>';
  return;
  }
function fAfficheTexte($Label,$NomObj,$Valeur,$Page) {
  $Saisie='';
  if ($Page<2) {$Saisie='placeholder="Obligatoire"';} else {$Saisie='disabled="disabled"';}
  echo '
          <tr>
            <td class="couleur1 hauteur2 cadre1">&nbsp;&nbsp;'.$Label.'</td>
            <td colspan=2 class="cadre1" style="padding-left:4px;">
              <input type="text" name="'.$NomObj.'" id="'.$NomObj.'" value="'.$Valeur.'" class="width4" '.$Saisie.'onChange="TrtSaisie(\''.$NomObj.'\');"></input>
            </td>
          </tr>';
  return;
  }
function fAfficheListe($Label,$NomObj,$ListeOptions,$Valeur,$Page) {
  $Saisie='';
  if ($Page>1) {$Saisie=' disabled="disabled"';}
  $Options= explode(",",$ListeOptions);
  $i=0;
  $sel='';
  echo '
          <tr>
            <td class="couleur1 hauteur2 cadre1">&nbsp;&nbsp;'.$Label.'</td>
            <td colspan=2 class="cadre1">
              <select name="'.$NomObj.'" style="bgcolor:black;" class="width4"'.$Saisie.'onChange="TrtSaisie(\''.$NomObj.'\');">';
  foreach ($Options as $Option) {
  $Option=trim($Option);
  if ($Option==$Valeur) {$sel=' selected="selected"';} else {$sel='';}
    echo '
                <option value="'.$Option.'"'.$sel.'>'.$Option.'</option>';
    $i++;}
  echo'
              </select>
            </td>
          </tr>';
  return;
  }
function fAfficheArea($Titre,$Label,$NomObj,$Valeur,$Page) {
  $Saisie='';
  $NbCr=0;
  $GLOBALS['Cpt']++;
  $NbCr=strlen($Valeur);
  if ($Page==1) {$Saisie='placeholder="Obligatoire"';}
  if ($GLOBALS['Cas']>$Page) {$Saisie='disabled="disabled"';}  
  echo '
        </table>
      </div>';
  if ($NbCr>345) {
  echo '
      <div id="infobulle-'.$GLOBALS['Cpt'].'" class="infobulle">'
        .$Valeur.'
      </div>';}
  echo '
      <div id="'.$NomObj.'" style="">
        <table>';
  fAfficheLigne();
  fAfficheEnTete($Titre);
  echo '
          <tr>
            <td class="centrer couleur1 hauteur1 cadre1";>'.$Label.'</td>
            <td colspan=2 class="cadre1" style="padding-left:4px;">';
  if ($NbCr>345) {
  echo '
              <a href="#" onmouseover="montre('.$GLOBALS['Cpt'].');" onmouseout="cache('.$GLOBALS['Cpt'].');">';}
  echo '
                <textarea name="'.$NomObj.'" class="hauteur1 width4" '.$Saisie.'>'.$Valeur.'</textarea>
';
  if ($NbCr>345) {echo '
              </a>';}
  echo '
            </td>
          </tr>
        </table>
      </div>      
      <div>      
        <table>';
  return;
  }
function fAfficheBoutons($NomObj,$Label) {
  echo '
          <tr>
            <td colspan=3 class="boutons">
              <input type="submit" name="'.$NomObj.'" value="'.$Label.'"></input>
            </td>
          </tr>';  
  return;
  }
function fAfficheRadios($Labels,$NomObj,$valeur) {
  $ListeLabels= explode(",",$Labels);
  $sel='';
  $i=0;
  $j=0;
  foreach ($ListeLabels as $Label) {
    $sel='';
    $j=count($ListeLabels)-$i-1;
    if ($valeur==$j) {$sel='checked="checked"';}
    echo '
            <tr>
              <td class="couleur1 hauteur4 cadre1" colspan=2>&nbsp;&nbsp;'.$Label.'</td>
              <td class="radios cadre1">
                <input type="radio" name="'.$NomObj.'" id="Btn'.$j.'" value="'.$j.'" '.$sel.')"></input>
              </td>
            </tr>';
    $i++;}
  return;
  }
function fAfficheHidden() {
echo '
          <tr>
            <td class="width1 hauteur3">
              <input type="hidden" name="Netbios" id="Netbios" value=""></input>
            </td>
            <td class="width2 hauteur3">
              <input type="hidden" name="Username" id="Username" value="'.$GLOBALS['IdRHAttendu'].'"></input>
            </td>
            <td class="width3 hauteur3">
              <input type="hidden" name="UsernameSession" id="UsernameSession" value=""></input>
            </td>
          </tr>';
  return;
}
function fAfficheCharte() {
echo '
    <tr>
      <td colspan=3 class="cadre1">
        <iframe src="charte.pdf#toolbar=0&statusbar=0&messages=0&navpanes=0&pagemode=none" height="400px" width="100%" frameborder="0"></iframe>
      </td>
    </tr>';
  return;
}
function fAfficheSignatureCharte($Coche,$Cas) {
  if ($Coche==1) {$Case=' Checked';} else {$Case='';}
  if ($Cas==1) {$Info='Cochez la case pour signer votre engagement  --->';} else {$Info='';$Case.=' disabled';}
    echo '
                    <tr>
                      <td colspan=2 class="couleur1 hauteur4 cadre1 rubriques">&nbsp;&nbsp;'.$Info.'</td>
                      <td class="radios cadre1">
                        <input type="checkbox" name="Sign" value="Sign"'.$Case.'></input>
                      </td>
                    </tr>';
  return;
}
function fAfficheEngagementResp($Cas) {
  $Couleur="4F1F1F";
  $Date="";
  $Date=date("d/m/Y");
  $Resp=$GLOBALS['Resp'];
  $User=$GLOBALS['User'];
  $Lieu=$GLOBALS['SiteCharteResp'];
//  $Lieu=$GLOBALS['SiteUser'];
  if ($User=="") {$User=str_repeat(".", 80);}
  if ($Resp=="") {$Resp=str_repeat(".", 80);}
  if ($Lieu=="") {$Lieu=str_repeat(".", 80);}
  if ($Cas==0)   {$Lieu='<span style="color:#'.$Couleur.'"><b>'.$Lieu.'</b></span>';
    } else {$Lieu='<input style="color:#'.$Couleur.';width=250pt;font-weight: bold" type="text" name="SignSiteResp" id="SignSiteResp" value="'.$Lieu.'" class="cadre3"></input>';}
  $GLOBALS['DateCharteResp']=date("Y-m-d");
  echo '
                  <tr>
                    <td colspan=3 class="cadre2">
                      <p>Je soussigné,&nbsp;&nbsp;<span style="color:#'.$Couleur.'"><b>'.$Resp.'</b></span>&nbsp;&nbsp;agissant en tant que responsable de pôle de&nbsp;&nbsp;<span style="color:#'.$Couleur.'"><b>'.$User.'</b></span>,&nbsp;déclare avoir pris connaissance et compris la <b><a href="'.$GLOBALS['LienBRH'].'" target="_blank">Charte de Sécurité des administrateurs informatiques</a></b> et m\'engage à en respecter les limites définies.</p>
                      <p>Fait à&nbsp;&nbsp;'.$Lieu.',&nbsp;&nbsp;le&nbsp;&nbsp;<span style="color:#'.$Couleur.'"><b>'.$Date.'</b></span>.
                      </p>
                    </td>
                  </tr>';
return;
}
function fAfficheEngagementUser($Cas) {
  $Couleur="4F1F1F";
  $Date="";
  $Date=date("d/m/Y");
  $User=$GLOBALS['User'];
  $Lieu=$GLOBALS['SiteCharteUser'];
  if ($User=="" OR $Cas==0) {$User=str_repeat(".", 80);}
  if ($Resp=="" OR $Cas==0) {$Resp=str_repeat(".", 80);}
  if ($Lieu=="" OR $Cas==0) {$Lieu=str_repeat(".", 80);}
  if ($Cas==0) {$Date='..../..../........';} else {$GLOBALS['DateCharteUser']=date("Y-m-d");}
  if ($Cas==0 OR $GLOBALS['Trt']=='22') {$User='<span style="color:#'.$Couleur.'"><b>'.$User.'</b></span>';} else {$User='<input style="color:#'.$Couleur.';width=250pt;font-weight: bold" type="text" name="SignUser" id="SignUser" value="'.$User.'" class="cadre3" onChange="TrtSaisie(\'SignUser\');"></input>';}  
  if ($Cas==0) {$Lieu='<span style="color:#'.$Couleur.'"><b>'.$Lieu.'</b></span>';} else {$Lieu='<input style="color:#'.$Couleur.';width=250pt;font-weight: bold" type="text" name="SignSiteUser" id="SignSiteUser" value="'.$Lieu.'" class="cadre3"></input>';}
  echo'
                  <tr>
                    <td colspan=3 class="cadre2">
                      <p>Je soussigné,&nbsp;&nbsp;'.$User.',&nbsp;déclare avoir pris connaissance et compris la 
                        <b><a href="'.$GLOBALS['LienBRH'].'" target="_blank">Charte de Sécurité des administrateurs informatiques</a></b>
                        et m\'engage à la respecter.</p>
                        <p>Fait à&nbsp;&nbsp;'.$Lieu.',&nbsp;&nbsp;le&nbsp;&nbsp;<span style="color:#'.$Couleur.'"><b>'.$Date.'</b></span>.
                      </p>
                    </td>
                  </tr>';
return;
}
function fCodecTexHex($Mot,$x) {
  $Opt=0;
  $Info="";
  if (substr($Mot,0,3)!=$x) {
    for ($i = 0; $i < strlen($Mot); $i++) {
      $Info=$Info.substr("00".dechex(ord(substr($Mot,$i,1))),-2);
    }
  } else {
    $Mot=substr($Mot,3);
    for ($i = 0; $i < strlen($Mot); $i=$i+2) {
      $Info=$Info.chr(hexdec(substr($Mot,$i,2)));
    }
  }
  return $Info;
}
function fCodecBrouillage($Mot,$Code1,$Code2,$Code3) {
  $Result="";
    for ($i=0; $i<strlen($Mot); $i++) {
      if ($i&1) {$j=2*variant_int(strlen($Mot)/2)-$i;} else {$j=$i;}
      $Result.=chr(((((ord(substr($Mot,$j,1))) ^ $Code1) ^ $Code2) ^ $Code3));
    }
  return $Result;
}
function fCodecodage($Mot) {
  $Code1=0;
  $Code2=0;
  $Code3=0;
  $x='2E7';
  $Info="";
  if (substr($Mot,0,3)!=$x) {
    $Code1=rand(33, 255);
    $i = 0;
    for (; ; ) {
      $i++;
      $Code2=rand(33, 255);
      if ($Code1!=$Code2) {break;}
      if ($i > 10) {break;}
    }
    $i = 0;
    for (; ; ) {
      $i++;
      $Code3=rand(33, 255);
      if (($Code1!=$Code3) AND ($Code2!=$Code3)) {break;}
      if ($i > 10) {break;}
    }
    $Info = chr($Code1).chr($Code2).chr($Code3);
    $Info.= fCodecBrouillage($Mot,$Code1,$Code2,$Code3);
    $Info = fCodecTexHex($Info,$x);
    $Info=$x.$Info;
  } else {
    $Mot=$x.fCodecTexHex($Mot,$x);
    $Code1 = ord(substr($Mot,3,1));
    $Code2 = ord(substr($Mot,4,1));
    $Code3 = ord(substr($Mot,5,1));
    $Mot=substr($Mot,6);
    $Info.=fCodecBrouillage($Mot,$Code1,$Code2,$Code3);
  }
  return $Info;
}
function fConvChaine($Mots , $Separateur="," , $Delimiteur="" , $Splitter="/") {
  $Resultat="";
  $ListeMots= explode($Splitter,$Mots);
  $Intercal=$Delimiteur;
  foreach ($ListeMots as $Mot) {
    $Resultat = $Resultat.$Intercal.$Mot.$Delimiteur;
    $Intercal=$Separateur.$Delimiteur;
    }
  return $Resultat;
}
function fVerifFormatIdRH($Valeur) {
  $Result=false;
  if ($Valeur=="") {$Result=true;}
  if (strlen($Valeur)!=6) {$Result=true;}
  if (intval(substr($Valeur,0,1))!=0 OR  substr($Valeur,0,1)=='0') {$Result=true;}
  if (intval(substr($Valeur,1,1))!=0 OR  substr($Valeur,1,1)=='0') {$Result=true;}
  if (intval(substr($Valeur,2,1))!=0 OR  substr($Valeur,2,1)=='0') {$Result=true;}
  if (intval(substr($Valeur,3,1))==0 AND substr($Valeur,3,1)!='0') {$Result=true;}
  if (intval(substr($Valeur,4,1))==0 AND substr($Valeur,4,1)!='0') {$Result=true;}
  if (intval(substr($Valeur,5,1))==0 AND substr($Valeur,5,1)!='0') {$Result=true;}
  return $Result;
}
function fVerifFormatMel($Valeur) {
  $Result=false;
  if ($Valeur=="") {$Result=true;}
  if ((substr($Valeur,-11)!='@laposte.fr') AND (substr($Valeur,-12)!='@sofipost.fr') AND (substr($Valeur,-12)!='@asendia.com') AND(substr($Valeur,-13)!='@mobigreen.fr')) {$Result=true;}
  if (strpos(substr($Valeur,0,(strlen($Valeur)-11)),'.') === false) {$Result=true;}
  return $Result;
}
function fVerifCodePage() {
  $Valeur = '';
  $GLOBALS['CodePage']    = "";
  $GLOBALS['NoID'] = 0;
  $Valeur = fCodecodage($_GET['Page']);
//echo "<script>alert(\"".$Valeur." => ".$GLOBALS['Page'].$GLOBALS['Cas']."\")</script>";
  $Result=true;
  if (substr(strtoupper($Valeur),2,3)!="DEM") {$Result=false;}
  if (strpos(" 11 12 13 14 15 21 22 31 41 42 43 44 45 51 52 53 99 ",substr($Valeur,0,2))===false) {$Result=false;}
  if (intval(substr($Valeur,5))==0) {$Result=false;}
  if (strlen($Valeur)!=11) {$Result=false;}
  for ($i=5;$i<11;$i++) {if (intval(substr($Valeur,$i,1))==0 AND substr($Valeur,$i,1)!='0') {$Result=false;}}
  if ($Result) {
                $GLOBALS['CodePage']    = $Valeur;
                $GLOBALS['NoID']        = intval(substr($Valeur,5));
                $GLOBALS['PageTraitee'] = 0;
               } else {
                $GLOBALS['CodePage']    = "";
                $GLOBALS['NoID']        = 0;
                $GLOBALS['PageTraitee'] = 2;}
  return $Result;
}
function fPageErreur($Erreur="Exécution impossible.") {
if ($Erreur=="Exécution impossible.") {$Titre="Accès refusé";} else {$Titre="Demande de droits d'administrateur";}
$MesErr="";
$Action="";
if (isset($_GET)) {if(isset($_GET['Page']) OR isset($_GET['Traitement']))  {$Action.="?";}
                   if(isset($_GET['Page']))                                {$Action.="Page=".$_GET['Page'];}
                   if(isset($_GET['Page']) AND isset($_GET['Traitement'])) {$Action.="&";}
                   if(isset($_GET['Traitement']))                          {$Action.="Traitement=".$_GET['Traitement'];}}
$MesErr="
                <html>
                  <head>
                    <title>$Titre</title>
                  </head>
                  <style type=\"text/css\" media=\"screen\">
                      body   {  background-color:#D9D9D9;
                                padding: 100px;}
                      table  {  width:100%;
                                height:100%;}
                      td     {  font-family: calibri; 
                                font-size: 14pt;
                                color: black;
                                background-color:#D9D9D9;
                                text-align: left;}
                  </style>
                  <body>
                    <form action=\"".$GLOBALS['URL'].$Action."\" method=\"post\">
                      <table>
                        <tr>
                          <td>
                            ".$Erreur."
                            <br><br><br><br>En cas de problème, contactez le Centre De Service par téléphone au 01 34 52 85 42 ou par courrier électronique à <a href=\"mailto:".$GLOBALS['MelCDS']."\">".$GLOBALS['MelCDS']."</a>.
                          </td>
                        </tr>
                      </table>
                    </form>
                  </body>
                </html>";
  exit($MesErr);
//                          
//                          ".$GLOBALS['CodePage']." => ".$GLOBALS['Statut']." - ".$GLOBALS['Page'].$GLOBALS['Cas']."<br>
//                          
  return;
}
?>
<?php /** Déclaration et réinitialisation des variables ******************************************************************************************/
$dbHost           = "localhost";
$dBName           = "droits-admin";
$dBUser           = "adm_droits-admin";
$dBPass           = "adm_droits-admin";
/************************************************************************************/
$dBDonnees        = "donnees";
$dBParam          = "param";
$dBSite           = "site";
$URL              = "http://droits-admin.dc.courrier.intra.laposte.fr/";
$TrtInit          = '41';
/************************************************************************************/
$LienBRH          = "http://www.ged.courrier.intra.laposte.fr/otcs/livelink.exe/fetch/-525869/606974/6745186/CORP-DSGG-2016-0176_Charte_administrateur.pdf?nodeid=13938679&vernum=-2";

$Valideur         = "";
$MelValideur      = "";
$MelCDS           = "";
$MelLitige        = "";

fBDDExtrairePDOParam();

$NoDemande        = 'Nouvelle demande';
$No               = 0;
$User             = '';
$IdRH             = '';
$MelUser          = '';
$TelUser          = '';
$DirUser          = '';
$SiteUser         = '';
$MotifUser        = '';
$Netbios          = '';
$Machine          = '';
$DateUser         = Date("Y-d-m");
$Resp             = '';
$IdRHResp         = '';
$MelResp          = '';
$TelResp          = '';
$AccordResp       = -1;
$CommentResp      = '';
$DateResp         = Date("Y-d-m");
$AccordSB         = -1;
$CommentSB        = '';
$DateSB           = Date("Y-d-m");
$AccordLitige     = -1;
$CommentLitige    = '';
$DateLitige       = Date("Y-d-m");
$AccordValideur   = -1;
$CommentValideur  = '';
$DateValideur     = Date("Y-d-m");
$SignUser         = '';
$CharteUser       = 0;
$SiteCharteUser   = '';
$DateCharteUser   = Date("Y-d-m");
$CharteResp       = 0;
$SiteCharteResp   = '';
$DateCharteResp   = Date("Y-d-m");
$DateCDS          = Date("Y-d-m");
$Statut           = 0;
$SB               = '';
$SiteSB           = '';                                    
$AbregeSB         = '';                                    
$RespSB           = '';                                    
$IdRHSB           = '';                                    
$TelSB            = '';                                    
$MelSB            = '';                                    
$RespSB2          = '';                                    
$IdRHSB2          = '';                                    
$TelSB2           = '';                                    
$MelSB2           = '';                                    

$Page             = intval(substr($TrtInit,0,1));      // 1 - Demande   / 2 - Signature          // 4 - Demande et signature
$Cas              = intval(substr($TrtInit,1,1));      // 1 - Demandeur / 2 - Responsable / 3 - Expert / 4 - Responsable technique / 5 - RSSI
$UserName         = '';
$UserNameSession  = '';
$NetbiosSession   = '';
$MesErr           = '';
$IdRHAttendu      = '';
$Trt              = $TrtInit;
$Cpt              = 0;

$PageTraitee      = 0;
$NoID             = 0;
$CodePage         = "";
?>
<?php /** Pré-Traitement et vérification des données en fonction du cas **************************************************************************/
$EvoStatut="";
$Valid=true;
if (isset($_GET)) {if(isset($_GET['Page'])) {$Valid=fVerifCodePage();}
                   if(isset($_GET['Traitement']) AND $PageTraitee==0) {if (fVerifCodePage($_GET['Traitement'])=="PageTraitée") {$PageTraitee=1;}}}

if ($CodePage!="") {$Page      = intval(substr($CodePage,0,1));
                    $Cas       = intval(substr($CodePage,1,1));
                    $NoDemande = substr($CodePage,2);
                    $No = intval(substr($NoDemande,3));
                    $Trt=strval($Page).strval($Cas);
/* Section à supprimer : Lignes temporaires en raison de l'ajout du rôle de Responsable Technique */										
                    if (($Trt=="14" OR $Trt=="44") AND ($No==2 OR $No==275 OR $No==276 OR $No==939 OR $No==940 OR $No==973)) {
										  $Cas=5;
                      $Trt=strval($Page).strval($Cas);
/* Fin de section */
										}
                    fBDDExtrairePDODonnees(' WHERE No='.strval($No));
                    fBDDExtrairePDOSite(" WHERE SiteSB='$SiteUser'");}
  $IdRHAttendu='';
  if ($Cas==1) {$IdRHAttendu=$IdRH;}
  if ($Cas==2) {$IdRHAttendu=$IdRHResp;}

  $Numero="";
  $Beneficiaire="";
  if ($NoID!=0){$Numero=" n° DEM".substr(strval(1000000+$NoID),-6);}
  if ($User!=""){$Beneficiaire=" concernant ".$User;}
  if ($Trt  == '11') {$EvoStatut="En attente de validation du responsable de pôle";}
  if ($Statut=='11') {$EvoStatut="En attente de validation du responsable de pôle";}
  if ($Statut=='12') {$EvoStatut="En attente de validation du service d'attribution des droits d'administration";}
  if ($Statut=='13') {$EvoStatut="En attente de validation du service d'attribution des droits d'administration";}
  if ($Statut=='14') {$EvoStatut="En attente de validation du service d'attribution des droits d'administration";}
  if ($Statut=='15') {$EvoStatut="En attente de signature numérique de la charte d'administration du responsable de pôle";}
  if ($Trt  == '41') {$EvoStatut="En attente de validation du responsable de pôle";}
  if ($Statut=='41') {$EvoStatut="En attente de validation du responsable de pôle";}
  if ($Statut=='42') {$EvoStatut="En attente de validation du service d'attribution des droits d'administration";}
  if ($Statut=='43') {$EvoStatut="En attente de validation du service d'attribution des droits d'administration";}
  if ($Statut=='44') {$EvoStatut="En attente de validation du service d'attribution des droits d'administration";}
  if ($Statut=='45') {$EvoStatut="En attente de validation du service d'attribution des droits d'administration";}
  if ($Statut=='21') {$EvoStatut="En attente de signature numérique de la charte d'administration du bénéficiaire";}
  if ($Statut=='22') {$EvoStatut="En attente de mise en place des droits d'administration";}
  if ($Statut=='31') {$EvoStatut="Les droits d'administration sont accordés, ce dossier est clôturé";}
  $MesErr="";
  if ($PageTraitee==2) {$Valid=false;}
  if ($Valid AND strpos(' 11 12 13 14 15 21 22 31 41 42 43 44 45 51 52 53 99 ',$Trt)===false) {$Valid=false;}
  if ($Valid AND $Cas<3 AND $IdRHAttendu!=""  AND $UserNameSession!="" AND $IdRHAttendu!=$UserNameSession) {$Valid=false;
      $MesErr = "Votre identifiant RH est $UserNameSession, vous n'êtes pas l'utilisateur attendu.<br><br>L'identifiant RH de l'utilisateur attendu est $IdRHAttendu.";}
  if ($Valid AND $Statut=='99') {$Valid=false;$MesErr="La demande".$Numero.$Beneficiaire." est annulée (doublon ou anomalie de saisie).";}
  if ($Valid AND (($PageTraitee==1 AND ($Trt=='12' OR $Trt=='42') AND $AccordResp==0) OR $Statut=='51')) {
      $Valid=false;$MesErr="La demande".$Numero.$Beneficiaire." est clôturée.<br>La validation a été refusée par le responsable de pôle.";}
  if ($Valid AND ($PageTraitee==1 AND ($Trt=='13' OR $Trt=='43') AND $AccordSB==0) OR $Statut=='52') {
      $Valid=false;$MesErr="La demande".$Numero.$Beneficiaire." est clôturée.<br>La validation a été refusée par le service d'attribution des droits d'administration.";}
  if ($Valid AND ($PageTraitee==1 AND ($Trt=='14' OR $Trt=='44') AND $AccordValideur==0) OR $Statut=='53') {
      $Valid=false;$MesErr="La demande".$Numero.$Beneficiaire." est clôturée.<br>La validation a été refusée par le service d'attribution des droits d'administration.";}
  if ($Valid AND $EvoStatut=="" AND ($PageTraitee==1 OR intval($Trt)<=intval($Statut))) {$Valid=false;}
  if ($Valid AND $PageTraitee==1) {$Valid=false;
                                   $Beneficiaire="";
                                   $Numero="";
                                   if ($User!=""){$Beneficiaire=" concernant ".$User;}
                                   if ($NoID!=0){$Numero=" n° DEM".substr(strval(1000000+$NoID),-6);}
                                   $MesErr="Votre demande".$Numero.$Beneficiaire." a bien été prise en compte.";
                                   $MesErr.="<br><br>Statut actuel de la demande : $EvoStatut.";
                                   $MesErr.='<br><br>Pour rappel, le BRH applicable à ce type de profil : <a href="'.$GLOBALS['LienBRH'].'" target="_blank">Charte de Sécurité des administrateurs informatiques</a>.';
																	 }
  if ($Valid AND (intval($Trt)<=intval($Statut) OR $Statut=='31')) {$Valid=false;$MesErr="Statut actuel de la demande".$Numero.$Beneficiaire." :<br>$EvoStatut.";$MesErr.='<br><br>Pour rappel, le BRH plus général applicable à ce type de profil : <a href="'.$GLOBALS['LienBRH'].'" target="_blank">Charte de Sécurité des administrateurs informatiques</a>.';}
  if (!$Valid) {fPageErreur($MesErr);}
?>
<?php /** Haut de page HTML **********************************************************************************************************************/
echo '
<html lang="fr">
  <head>
    <meta charset="ISO-8859-15" />
    <meta http-equiv="Content-Type" content="text/html" />
    <title>Demande de droits d\'administrateur</title>
		<link rel="shortcut icon" href="/Droits.ico" />
  </head>
  <style type="text/css" media="screen">
      body                {  width:100%;
                             background-color:#D9D9D9;
                             border-width: 0;
                             border-spacing: 0;
                             padding: 0;
                             border-collapse:collapse;           }
      table               {  width:60%;
                             padding: 0;
                             border: 0;
                             border-spacing: 0;
                             border-collapse: collapse;          }
      tr                  {  width:100%;
                             padding: 0;                         }
      td                  {  font-family: calibri; 
                             font-size: 10pt;
                             background-color: white;
                             color: black;
                             text-align: left;
                             padding: 0;                         }
      input[disabled]     {  background-color: white;
                             border-color: white;
                             border-width: 0;
                             font-size: 10pt;                    }
      select[disabled]    {  background-color: white;
                             border-color: white;
                             border-width: 0;
                             font-size: 10pt;                    }
      textarea[disabled]  {  background-color: white;
                             border-color: white;
                             border-width: 0;
                             overflow:hidden;
                             font-size: 10pt;                    }
      hidden[disabled]    {  background-color: white;
                             border-color: white;
                             border-width: 0;
                             font-size: 10pt;                    }
      input               {  background-color: white;
                             border-color: white;
                             border-width: 0;
                             font-size: 10pt;                    }
      select              {  background-color: white;
                             border-color: white;
                             border-width: 0;
                             font-size: 10pt;                    }
      textarea            {  background-color: white;
                             border-color: white;
                             border-width: 0;
                             overflow:hidden;
                             font-size: 10pt;                    }
      hidden              {  background-color: white;
                             border-color: white;
                             border-width: 0;
                             font-size: 10pt;                    }
      .bandeau            {  text-align: center;
                             height:20pt;
                             font-size: 19pt;
                             font-weight: bold;
                             background-color: #DCE6F1;
                             color:black;                        }
      .rubriques          {  text-align: center;
                             font-size: 12pt; 
                             font-weight: bold;                  }
      .radios             {  text-align: right;
                             width: 10px;
                             width: 0;                           }
      .boutons            {  text-align: center;
                             border-width: 0;
                             background-color:#D9D9D9;
                             width:50%;                          }
      .centrer            {  text-align: center;                 }
      .couleur1           {  background-color: #FFFFCC;          }
      .couleur2           {  background-color: #DCE6F1;          }
      .width1             {  width:30%;                          }
      .width2             {  width:68%;                          }
      .width3             {  width:2%;                           }
      .width4             {  width:100%;                         }
      .hauteur1           {  height:100;
                             resize: none;                       }
      .hauteur4           {  height:8pt;                         }
      .hauteur3           {  height:7pt;
                             background-color:#D9D9D9;           }
      .hauteur4           {  height:19pt;                        }
      .cadre1             {  border:solid black 1.0pt;           }
      .cadre2             {  border:solid black 1.0pt;
                             color:black;
                             line-height:18pt;
                             padding-top:8px;
                             padding-left:14px;
                             padding-right:14px;
                             padding-bottom:8px;                 }
      .cadre3             {  border-left:solid #ccc 1.0pt;
                             border-right:solid #ccc 1.0pt;
                             border-bottom:solid #ccc 1.0pt;     }
      .hidden             {  border-width: 0;
                             background-color:#D9D9D9;           }
      .infobulle          {  position: absolute;    
                             visibility : hidden;
                             border: 1px solid Black;
                             padding: 10px;
                             font-family: Verdana, Arial;
                             font-size: 10px;
                             background-color: #FFFFCC;
                             width : 400px;                      }
';
$Action="";
if (isset($_GET)) {if(isset($_GET['Page']) OR isset($_GET['Traitement']))  {$Action.="?";}
                   if(isset($_GET['Page']))                                {$Action.="Page=".$_GET['Page'];}
                   if(isset($_GET['Page']) AND isset($_GET['Traitement'])) {$Action.="&";}
                   if(isset($_GET['Traitement']))                          {$Action.="Traitement=".$_GET['Traitement'];}
                  }
echo '  </style>
  <body onload="javascript:ValeursLocales()">
    <form action="'.$URL.$Action.'" method="post">
      <div>
        <table>';
?>
<?php /** Récupération des données du formulaire *************************************************************************************************/
if ($No!=0) {$NoDemande  = 'DEM'.substr(strval(1000000+$No),-6);} else {$NoDemande="Nouvelle demande";}
if($PageTraitee!=2 AND isset($_POST)) {
  if(isset($_POST['User']))             {$User              = trim($_POST['User']);}
  if(isset($_POST['IdRH']))             {$IdRH              = trim(strtoupper($_POST['IdRH']));}
  if(isset($_POST['MelUser']))          {$MelUser           = trim(strtolower($_POST['MelUser']));}
  if (substr($MelUser,0,7)=='mailto:')  {$MelUser=substr($MelUser,7);}
  if(isset($_POST['TelUser']))          {$TelUser           = trim($_POST['TelUser']);}
  if(isset($_POST['DirUser']))          {$DirUser           = trim($_POST['DirUser']);}
  if(isset($_POST['SiteUser']))         {$SiteUser          = trim($_POST['SiteUser']);}
  if(isset($_POST['MotifUser']))        {$MotifUser         = trim($_POST['MotifUser']);}
  if(isset($_POST['Netbios']))          {$Netbios           = trim(strtoupper($_POST['Netbios']));}
  if(isset($_POST['Machine']))          {$Machine           = trim(strtoupper($_POST['Machine']));}
  if(isset($_POST['UsernameSession']))  {$UsernameSession   = trim(strtoupper($_POST['UsernameSession']));}
  if(isset($_POST['Resp']))             {$Resp              = trim($_POST['Resp']);}
  if(isset($_POST['IdRHResp']))         {$IdRHResp          = trim(strtoupper($_POST['IdRHResp']));}
  if(isset($_POST['MelResp']))          {$MelResp           = trim(strtolower($_POST['MelResp']));}
  if (substr($MelResp,0,7)=='mailto:')  {$MelResp=substr($MelResp,7);}
  if(isset($_POST['TelResp']))          {$TelResp           = trim($_POST['TelResp']);}
  if(isset($_POST['AccordResp']))       {$AccordResp        = trim($_POST['AccordResp']);}
  if(isset($_POST['CommentResp']))      {$CommentResp       = trim($_POST['CommentResp']);}
  if(isset($_POST['AccordSB']))         {$AccordSB          = trim($_POST['AccordSB']);}
  if(isset($_POST['CommentSB']))        {$CommentSB         = trim($_POST['CommentSB']);}
  if(isset($_POST['AccordLitige']))     {$AccordLitige      = trim($_POST['AccordLitige']);}
  if(isset($_POST['CommentLitige']))    {$CommentLitige     = trim($_POST['CommentLitige']);}
  if(isset($_POST['AccordValideur']))   {$AccordValideur    = trim($_POST['AccordValideur']);}
  if(isset($_POST['CommentValideur']))  {$CommentValideur   = trim($_POST['CommentValideur']);}
  if(isset($_POST['SignUser']))         {$SignUser          = trim($_POST['SignUser']);}
  if(isset($_POST['SignSiteUser']))     {$SiteCharteUser    = trim($_POST['SignSiteUser']);}
  if(isset($_POST['SignSiteResp']))     {$SiteCharteResp    = trim($_POST['SignSiteResp']);}
  if(isset($_POST['Sign']))             {if ($Page==2 AND $Cas==1) {$CharteResp = 1;}
                                         if ($Page==2 AND $Cas==2) {$CharteUser = 1;}
                                         if ($Page==4 AND $Cas==1) {$CharteUser = 1;}
                                         if ($Page==4 AND $Cas==2) {$CharteResp = 1;}}
}
?>
<?php /** Vérification de la validité de la saisie ***********************************************************************************************/
$Valid=false;
if ($CodePage != "" AND $PageTraitee==0) {
                      $Page = intval(substr($CodePage,0,1));
                      $Cas = intval(substr($CodePage,1,1));
                      $NoDemande = substr($CodePage,2);
                      $Trt=strval($Page).strval($Cas);} else {
                      $Page=intval(substr($TrtInit,0,1));$Cas=intval(substr($TrtInit,1,1));$Trt=$TrtInit;}
/* Section à supprimer : Lignes temporaires en raison de l'ajout du rôle de Responsable Technique */										
                    if (($Trt=="14" OR $Trt=="44") AND ($No==2 OR $No==275 OR $No==276 OR $No==939 OR $No==940 OR $No==973)) {
										  $Cas=5;
                      $Trt=strval($Page).strval($Cas);}
/* Fin de section */
  if(isset($_POST['Soumettre'])) {
    $MessErr='';
    $Msg1='';
    $Msg2='';
    $Msg3='';
    $Msg4='';

    $IdRHAttendu='';
    if ($Cas==1) {$IdRHAttendu=$IdRH;}
    if ($Cas==2) {$IdRHAttendu=$IdRHResp;}
    //if (($Cas==1 OR $Cas==2) AND $UsernameSession!="" AND $IdRHAttendu!="" AND $UsernameSession!=$IdRHAttendu) {fPageErreur("Vous n'êtes pas l'utilisateur attendu.");}

    //if ($Cas==3 AND $UsernameSession!="" AND ($UsernameSession!=$IdRHSB OR $UsernameSession!=$IdRHSB2)) {fPageErreur("Vous n'êtes pas l'utilisateur attendu.");}

    if (($Page==1 OR $Page==4) AND $Cas==1 AND $User=='')                                              {$Msg1.='\n - NOM Prénom non renseigné';}
    if (($Page==1 OR $Page==4) AND $Cas==1 AND fVerifFormatIdRH($IdRH))                                {$Msg1.='\n - Identifiant RH non renseigné ou non conforme';}
    if (($Page==1 OR $Page==4) AND $Cas==1 AND fVerifFormatMel($MelUser))                              {$Msg1.='\n - Adresse mail non renseignée ou non conforme';}
    if (($Page==1 OR $Page==4) AND $Cas==1 AND $TelUser=='')                                           {$Msg1.='\n - Téléphone non renseigné';}
    if (($Page==1 OR $Page==4) AND $Cas==1 AND $DirUser=='')                                           {$Msg1.='\n - Direction non renseignée';}
    if (($Page==1 OR $Page==4) AND $Cas==1 AND $SiteUser=='')                                          {$Msg1.='\n - Site non renseigné';}
    if (($Page==1 OR $Page==4) AND $Cas==1 AND $Machine=='')                                           {$Msg1.='\n - Nom d\'ordinateur non renseigné';}

    if (($Page==1 OR $Page==4) AND $Cas==1 AND $MotifUser=='')                                         {$Msg2.='\n - Motivation obligatoire';}

    if (($Page==1 OR $Page==4) AND $Cas==2 AND $AccordResp==-1)                                        {$Msg2.='\n - Décision non précisée';}
    if (($Page==1 OR $Page==4) AND $Cas==3 AND $AccordSB==-1)                                          {$Msg2.='\n - Décision non précisée';}

    if (($Page==1 OR $Page==4) AND $Cas==4 AND $AccordLitige==-1)                                      {$Msg2.='\n - Décision non précisée';}
    if (($Page==1 OR $Page==4) AND $Cas==5 AND $AccordValideur==-1)                                    {$Msg2.='\n - Décision non précisée';}

    if (($Page==1 OR $Page==4) AND $Cas==2 AND $AccordResp==0 AND $CommentResp=='')                    {$Msg2.='\n - Commentaires obligatoires en cas de refus';}
    if (($Page==1 OR $Page==4) AND $Cas==3 AND $AccordSB==0 AND $CommentSB=='')                        {$Msg2.='\n - Commentaires obligatoires en cas de refus';}
    if (($Page==1 OR $Page==4) AND $Cas==3 AND $AccordSB==1 AND $CommentSB=='')                        {$Msg2.='\n - Commentaires obligatoires si non favorable';}

    if (($Page==1 OR $Page==4) AND $Cas==4 AND $AccordLitige==0 AND $CommentLitige=='')                {$Msg2.='\n - Commentaires obligatoires en cas de refus';}
    if (($Page==1 OR $Page==4) AND $Cas==5 AND $AccordValideur==0 AND $CommentValideur=='')            {$Msg2.='\n - Commentaires obligatoires en cas de refus';}

    if (($Page==1 OR $Page==4) AND $Cas==1 AND $Resp=='')                                              {$Msg3.='\n - NOM Prénom non renseigné';}
    if (($Page==1 OR $Page==4) AND $Cas==1 AND fVerifFormatIdRH($IdRHResp))                            {$Msg3.='\n - Identifiant RH non renseigné ou non conforme';}
    if (($Page==1 OR $Page==4) AND $Cas==1 AND fVerifFormatMel($MelResp))                              {$Msg3.='\n - Adresse mail non renseignée ou non conforme';}
    if (($Page==1 OR $Page==4) AND $Cas==1 AND $TelResp=='')                                           {$Msg3.='\n - Téléphone non renseigné';}

    if ($Page==4 AND $Cas==1 AND $SignUser=='')                                                        {$Msg4.='\n - Signataire non renseigné';}
    if ((($Page==2 AND $Cas==1) OR ($Page==4 AND $Cas==2)) AND $SiteCharteResp=='')                    {$Msg4.='\n - Lieu non renseigné';}
    if ((($Page==2 AND $Cas==1) OR ($Page==4 AND $Cas==2)) AND $CharteResp==0)                         {$Msg4.='\n - Charte non signée';}

    if ((($Page==2 AND $Cas==2) OR ($Page==4 AND $Cas==1)) AND $SiteCharteUser=='')                    {$Msg4.='\n - Lieu non renseigné';}
    if ((($Page==2 AND $Cas==2) OR ($Page==4 AND $Cas==1)) AND $CharteUser==0)                         {$Msg4.='\n - Charte non signée';}

    if ($Msg1!='') {$Msg1='IDENTIFICATION DU BENEFICIAIRE'.$Msg1.'.\n\n';}
    if ($Msg2!='') {$Msg2='MOTIVATION ou COMMENTAIRES'.$Msg2.'.\n\n';}
    if ($Msg3!='') {$Msg3='IDENTIFICATION DU RESPONSABLE DE PÔLE'.$Msg3.'.\n\n';}
    if ($Msg4!='') {$Msg4='SIGNATURE DE LA CHARTE'.$Msg4.'.\n\n';}
    $MessErr=$Msg1.$Msg2.$Msg3.$Msg4;
    $Valid=true;
    if ($MessErr!='') {
                       $MessErr='Les informations saisies ne permettent pas de poursuivre.\nDes informations sont manquantes ou incorrectes :\n\n'.$Msg1.$Msg2.$Msg3.$Msg4;
                       echo "<script>alert(\"$MessErr\")</script>";
                       $Valid=false;}
    unset($_POST['Soumettre']);
}
?>
<?php /** Soumission des données validées ********************************************************************************************************/
if ($Valid) { $DateUser                 = Date("Y-m-d");
              $DateResp                 = Date("Y-m-d");
              $DateSB                   = Date("Y-m-d");
              $DateValideur             = Date("Y-m-d");
              $DateCharteUser           = Date("Y-m-d");
              $DateCharteResp           = Date("Y-m-d");
              $DateCDS                  = Date("Y-m-d");
              if ($CodePage == "" AND $PageTraitee==0) {
                  try {$dbh = new PDO("mysql:host=$dbHost;dbname=$dBName",$dBUser,$dBPass);}
                  catch (Exception $e) {die("Impossible de se connecter: " . $e->getMessage()."<br><br>Veuillez contacter le CDS à enova.cds@laposte.fr ou au 01 34 52 85 42.");}
                  try {$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                      if ($NoID==0) {
                          $dbh->exec("insert into ".$dBDonnees." (User) values ('Tempo')");
                          $NoID = $dbh->lastInsertId();
                      }
                  }
                  catch (Exception $e) {/**/}
                  $No = $NoID;
                  $Trt=$TrtInit;
                  $NoDemande  = 'DEM'.substr(strval(1000000+$No),-6);
                  $CodePage=$Trt.$NoDemande;
                  fBDDExtrairePDOSite(" WHERE SiteSB='$SiteUser'");
                  fMailGestCorp(1);
                  if ($TrtInit=='11') {$Mel=2;} else {$Mel=22;}
                  fMailGestCorp($Mel);
                  fBDDModifPDO("User/IdRH/MelUser/TelUser/DirUser/SiteUser/MotifUser/Netbios/Machine/Resp/IdRHResp/MelResp/TelResp/SB/IdRHSB/MelSB/SB2/IdRHSB2/MelSB2/IdRHDemUser/SiteCharteUser/CharteUser/DateCharteUser/DateUser/Statut/AccordResp/AccordSB/AccordLitige/AccordValideur",array("$User","$IdRH","$MelUser","$TelUser","$DirUser","$SiteUser","$MotifUser","$Netbios","$Machine","$Resp","$IdRHResp","$MelResp","$TelResp","$RespSB","$IdRHSB","$MelSB","$RespSB2","$IdRHSB2","$MelSB2","$UsernameSession","$SiteCharteUser",$CharteUser,$DateCharteUser,$DateUser,$Trt,-1,-1,-1,-1)," WHERE No=$No");
              }
              if ($Trt=="12") {
                  fBDDExtrairePDOSite(" WHERE SiteSB='$SiteUser'");
                  if ($AccordResp==0) {
                      fMailGestCorp(3);
                      $Trt='51';
                      } else {
                      fMailGestCorp(4);fMailGestCorp(5);
                  }
                  fBDDModifPDO("AccordResp/CommentResp/IdRHDemResp/DateResp/Statut",array("$AccordResp","$CommentResp","$UsernameSession",$DateResp,$Trt)," WHERE No=$No");
              }
               if ($Trt=="42") {
                  fBDDExtrairePDOSite(" WHERE SiteSB='$SiteUser'");
                  if ($AccordResp==0) {
                      fMailGestCorp(3);
                      $Trt='51';
                      } else {
                      fMailGestCorp(4);fMailGestCorp(25);
                  }
                  fBDDModifPDO("AccordResp/CommentResp/IdRHDemResp/SiteCharteResp/CharteResp/DateCharteResp/DateResp/Statut",array("$AccordResp","$CommentResp","$UsernameSession","$SiteCharteResp",$CharteResp,$DateCharteResp,$DateResp,$Trt)," WHERE No=$No");
              }
             if ($Trt=="13") {
                  if ($AccordSB==0) {fMailGestCorp(11);$Trt='52';} 
                  if ($AccordSB==1) {fMailGestCorp(14);}

/*** Zone à rétablir ********************************************************************************************************************************************/
                  if ($AccordSB==2) {fMailGestCorp(12);$Trt='14';}
/*** Fin de zone à rétablir *************************************************************************************************************************************/

/*** Zone à supprimer *******************************************************************************************************************************************
                  if ($AccordSB==2) {$Trt='14';}
*** Fin de zone à supprimer ************************************************************************************************************************************/

                  fBDDModifPDO("AccordSB/CommentSB/IdRHDemSB/DateSB/Statut",array("$AccordSB","$CommentSB","$UsernameSession",$DateSB,$Trt)," WHERE No=$No");
									$Trt='13';

/*** Zone à supprimer *******************************************************************************************************************************************
                  if ($AccordSB==2) {$AccordValideur==1;$Trt='15';}
*** Fin de zone à supprimer ************************************************************************************************************************************/

              }
              if ($Trt=="43") {
                  if ($AccordSB==0) {fMailGestCorp(11);$Trt='52';}
                  if ($AccordSB==1) {fMailGestCorp(15);}

/*** Zone à rétablir ********************************************************************************************************************************************/
                  if ($AccordSB==2) {fMailGestCorp(32);$Trt='44';}
/*** Fin de zone à rétablir *************************************************************************************************************************************/

/*** Zone à supprimer *******************************************************************************************************************************************
                  if ($AccordSB==2) {$Trt='44';}
*** Fin de zone à supprimer ************************************************************************************************************************************/

                  fBDDModifPDO("AccordSB/CommentSB/IdRHDemSB/DateSB/Statut",array("$AccordSB","$CommentSB","$UsernameSession",$DateSB,$Trt)," WHERE No=$No");
									$Trt='43';

/*** Zone à supprimer *******************************************************************************************************************************************
                  if ($AccordSB==2) {$AccordValideur==1;$Trt='45';}
*** Fin de zone à supprimer ************************************************************************************************************************************/

              }
              if ($Trt=="14") {
                  if ($AccordLitige==0) {fMailGestCorp(21);$Trt='52';}

/*** Zone à rétablir ********************************************************************************************************************************************/
                  if ($AccordLitige==1) {fMailGestCorp(12);} 
/*** Fin de zone à rétablir *************************************************************************************************************************************/

                  fBDDModifPDO("AccordLitige/CommentLitige/IdRHDemLitige/DateLitige/Statut",array("$AccordLitige","$CommentLitige","$UsernameSession",$DateLitige,$Trt)," WHERE No=$No");
									$Trt=14;

/*** Zone à supprimer *******************************************************************************************************************************************
                  if ($AccordLitige==1) {$Trt='15';} 
*** Fin de zone à supprimer ************************************************************************************************************************************/

              }
              if ($Trt=="44") {
                  if ($AccordLitige==0) {fMailGestCorp(21);$Trt='52';}

/*** Zone à rétablir ********************************************************************************************************************************************/
                  if ($AccordLitige==1) {fMailGestCorp(32);}
/*** Fin de zone à rétablir *************************************************************************************************************************************/

                  fBDDModifPDO("AccordLitige/CommentLitige/IdRHDemLitige/DateLitige/DateCDS/Statut",array("$AccordLitige","$CommentLitige","$UsernameSession",$DateLitige,$DateCDS,$Trt)," WHERE No=$No");

/*** Zone à supprimer *******************************************************************************************************************************************
                  if ($AccordLitige==1) {$Trt='45';}
*** Fin de zone à supprimer ************************************************************************************************************************************/

              }
              if ($Trt=="15") {
                  if ($AccordValideur==0) {
                      fMailGestCorp(8);
                      $Trt='53';
                      } else {
                      fMailGestCorp(6);
                  }
                  fBDDModifPDO("AccordValideur/CommentValideur/IdRHDemValideur/DateValideur/Statut",array("$AccordValideur","$CommentValideur","$UsernameSession",$DateValideur,$Trt)," WHERE No=$No");
              }
              if ($Trt=="45") {
                  if ($AccordValideur==0) {
                      fMailGestCorp(8);
                      $Trt='53';
                      } else {
                      fMailGestCorp(9);
                      fMailGestCorp(10);
                      fMailGestCorp(13);
                      $Trt='31';
                  }
                  fBDDModifPDO("AccordValideur/CommentValideur/IdRHDemValideur/DateValideur/DateCDS/Statut",array("$AccordValideur","$CommentValideur","$UsernameSession",$DateValideur,$DateCDS,$Trt)," WHERE No=$No");
              }
              if ($Trt=="21") {
                  fMailGestCorp(7);
                  fBDDModifPDO("IdRHDemCharteResp/SiteCharteResp/CharteResp/DateCharteResp/Statut",array("$UsernameSession","$SiteCharteResp",$CharteResp,$DateCharteResp,21)," WHERE No=$No");
              }
              if ($Trt=="22") {
                  fBDDModifPDO("IdRHDemCharteUser/SiteCharteUser/CharteUser/DateCharteUser/Statut",array("$UsernameSession","$SiteCharteUser",$CharteUser,$DateCharteUser,22)," WHERE No=$No");
              }
              if ($Trt=="22" AND $CharteUser==1) {
                  fMailGestCorp(9);
                  fMailGestCorp(10);
                  fMailGestCorp(13);
                  fBDDModifPDO("DateCDS/Statut",array($DateCDS,31)," WHERE No=$No");
              }
              print("<script type=\"text/javascript\">setTimeout('location=(\"".$URL."?Page=".fCodecodage($Trt.$NoDemande)."&Traitement=".fCodecodage("PageTraitée")."\")' ,10);</script>");
          }
?>
<?php /** Contenu de la page HTML selon le cas attendu *******************************************************************************************/
if ($Page==1 OR $Page==4) { /** Fiche de demande (partie commune) ********************************************************************************/
  fAfficheTitre("Fiche de demande d'obtention de droits d'administrateur");
  fAfficheLigne();
  fAfficheInfo('Demande N°','NoDemande',$NoDemande);
  fAfficheLigne();
  fAfficheEnTete('IDENTIFICATION DU BENEFICIAIRE');
  fAfficheTexte('NOM Prénom','User',$User,$Cas);
  fAfficheTexte('Identifiant RH','IdRH',strtoupper($IdRH),$Cas);
  fAfficheTexte('Adresse mail','MelUser',$MelUser,$Cas);
  fAfficheTexte('Téléphone','TelUser',$TelUser,$Cas);
  fAfficheTexte('Direction','DirUser',$DirUser,$Cas);
  $ListeSites=",".fBDDExtrairePDOSiteArray();
  fAfficheListe('Site','SiteUser',$ListeSites,$SiteUser,$Cas);
  fAfficheTexte('Nom de l\'ordinateur du bénéficiaire','Machine',$Machine,$Cas);
  if ($Cas==1) {$mtf='Merci de motiver votre demande en quelques lignes';} else {$mtf='Motivation du demandeur';}
  fAfficheArea('MOTIF DE LA DEMANDE',$mtf,'MotifUser',$MotifUser,1);
  if ($Cas!=2) { /** Fiche de demande (Partie Identification du responsable de pôle) *************************************************************/
    fAfficheLigne();
    fAfficheEnTete('IDENTIFICATION DU RESPONSABLE DE PÔLE (minimum Groupe B)');
    fAfficheTexte('NOM Prénom','Resp',$Resp,$Cas);
    fAfficheTexte('Identifiant RH','IdRHResp',strtoupper($IdRHResp),$Cas);
    fAfficheTexte('Adresse mail','MelResp',$MelResp,$Cas);
    fAfficheTexte('Téléphone','TelResp',$TelResp,$Cas);
    }
  if ($Cas==2) { /** Fiche de demande (Partie du responsable de pôle) ****************************************************************************/
    fAfficheLigne();
    fAfficheEnTete('DECISION DU RESPONSABLE DE PÔLE');
    fAfficheRadios('Je valide la demande de droits d\'administrateur,Je ne valide pas la demande de droits d\'administrateur','AccordResp',$AccordResp);
    fAfficheArea('COMMENTAIRES DU RESPONSABLE DE PÔLE','Commentaires','CommentResp',$CommentResp,2);
  }
  if ($Cas>2) { /** Fiche de demande (Partie du SB) **********************************************************************************************/
    fAfficheArea('COMMENTAIRES DU RESPONSABLE DE PÔLE','Commentaires','CommentResp',$CommentResp,2);
  }
  if ($Cas==3) { /** Fiche de demande (Partie du SB) *********************************************************************************************/
    fAfficheLigne();
    fAfficheEnTete('AVIS DE L\'EXPERT TECHNIQUE');
    fAfficheRadios('Favorable,Non favorable,Refusé','AccordSB',$AccordSB);
    fAfficheArea('COMMENTAIRES DE L\'EXPERT TECHNIQUE','Commentaires','CommentSB',$CommentSB,3);
  }
  if ($Cas==4) { /** Fiche de demande (Partie du Responsable Technique) **************************************************************************/
    $ASB="";
    if ($AccordSB == 0) {$ASB="Avis suite à expertise technique : Refusé.\n\n";}
    if ($AccordSB == 1) {$ASB="Avis suite à expertise technique : Non favorable.\n\n";}
    if ($AccordSB == 2) {$ASB="Avis suite à expertise technique : Favorable.\n\n";}
    fAfficheArea('COMMENTAIRES DE L\'EXPERT TECHNIQUE','Commentaires','CommentSB',$ASB.$CommentSB,3);
    fAfficheLigne();
    fAfficheEnTete('DECISION DU RESPONSABLE TECHNIQUE');
    fAfficheRadios('Je valide la demande de droits d\'administrateur,Je ne valide pas la demande de droits d\'administrateur','AccordLitige',$AccordLitige);
    fAfficheArea('COMMENTAIRES DU RESPONSABLE TECHNIQUE','Commentaires','CommentLitige',$CommentLitige,4);
  }
  if ($Cas==5) { /** Fiche de demande (Partie du RSSI) *******************************************************************************************/
    $ASB="";
    if ($AccordSB == 0) {$ASB="Avis suite à expertise technique : Refusé.\n\n";}
    if ($AccordSB == 1) {$ASB="Avis suite à expertise technique : Non favorable.\n\n";}
    if ($AccordSB == 2) {$ASB="Avis suite à expertise technique : Favorable.\n\n";}
    fAfficheArea('COMMENTAIRES DE L\'EXPERT TECHNIQUE','Commentaires','CommentSB',$ASB.$CommentSB,3);
    fAfficheLigne();
    if ($AccordSB == 1) {fAfficheArea('COMMENTAIRES DU RESPONSABLE TECHNIQUE','Commentaires','CommentLitige',$CommentLitige,3);
    fAfficheLigne();}
    fAfficheEnTete('VALIDATION DU RSSI DU COURRIER');
    fAfficheRadios('Je valide la demande de droits d\'administrateur,Je ne valide pas la demande de droits d\'administrateur','AccordValideur',$AccordValideur);
    fAfficheArea('COMMENTAIRES DU RSSI DU COURRIER','Commentaires','CommentValideur',$CommentValideur,5);
  }
  if ($Page==4 and ($Cas==1 or $Cas==2)) {
  if ($Cas==1) {$EngCh="DE L'AGENT";$SgnCh=$CharteUser;} else {$EngCh="DU RESPONSABLE DE PÔLE";$SgnCh=$CharteResp;}
  /** Signature de la charte (Partie du bénéficiaire) *****************************************************************************/
  fAfficheLigne();
  fAfficheEnTete(strtoupper("Charte de Sécurité des administrateurs informatiques"));
  fAfficheCharte();
        fAfficheLigne();
        fAfficheEnTete("ENGAGEMENT PERSONNEL ".$EngCh);
        if ($Cas==1) {fAfficheEngagementUser(2);} else {fAfficheEngagementResp(1);}
        fAfficheSignatureCharte($SgnCh,1);}
}
if ($Page==2) { /** Signature de la charte (Partie commune) **************************************************************************************/
  fAfficheTitre("Signature de la charte des droits d'administrateur");
  fAfficheLigne();
  fAfficheEnTete(strtoupper("Charte de Sécurité des administrateurs informatiques"));
  fAfficheCharte();
  /** Signature de la charte (Partie du responsable de pôle) **********************************************************************/
        fAfficheLigne();
        fAfficheEnTete('ENGAGEMENT DU RESPONSABLE DE PÔLE');
        fAfficheEngagementResp(2-$Cas);
        fAfficheSignatureCharte($CharteResp,2-$Cas);
  /** Signature de la charte (Partie du bénéficiaire) *****************************************************************************/
        fAfficheLigne();
        fAfficheEnTete("ENGAGEMENT PERSONNEL DE L'AGENT");
        fAfficheEngagementUser($Cas-1);
        fAfficheSignatureCharte($CharteUser,$Cas-1);
}
/***Fin de page HTML******************************************************************************************************************************/
?>
<?php /** Bas de page HTML ***********************************************************************************************************************/
  fAfficheLigne();
  fAfficheBoutons('Soumettre','Soumettre');
  fAfficheHidden();
echo'
        </table>
      </div>
    </form>
    <script type="text/javascript">
      function ValeursLocales(){
        var WinNetwork = new ActiveXObject("WScript.Network");
        var objet = document.getElementById("Netbios");
        var NetB = WinNetwork.computername.toUpperCase();
        objet.value = NetB;';
if ($Trt=='11' OR $Trt=='41') {echo'
        var objet = document.getElementById("Machine");
        var NetB = WinNetwork.computername.toUpperCase();
        objet.value = NetB;';}
echo'
        var objet = document.getElementById("UsernameSession");
        var User = WinNetwork.userName.toUpperCase();
        objet.value = User;}

      var Mouse;
      document.onmousemove = DoMouse;
      function DoMouse(e) { Mouse = (typeof e == "undefined") ? window.event : e;  }
      function montre(id) { var Infobulle = document.getElementById("infobulle-"+id)
        if(Infobulle) {Infobulle.style.visibility = "visible";
          if(document.documentElement) {
            Infobulle.style.left = Mouse.clientX + document.documentElement.scrollLeft + 20 + "px";
            Infobulle.style.top =  Mouse.clientY + document.documentElement.scrollTop + 10 + "px";
          } else {
            Infobulle.style.left = Mouse.clientX + document.body.scrollLeft + 20 + "px";
            Infobulle.style.top =  Mouse.clientY + document.body.scrollTop + 10 + "px";}}}

      function cache(id) {setTimeout("docache("+id+")", 30);}

      function docache(id) { var Infobulle = document.getElementById("infobulle-"+id)
                             if(Infobulle) {Infobulle.style.visibility = "hidden";}}

      function TrtSaisie(objet) {
        if (objet=="User" || objet=="SiteUser") {
            var valr = document.getElementsByName(objet)[0].value;
            var obj  = document.getElementById("Sign" + objet);
            //if (objet=="SiteUser") {
            //  if (obj.value=="") {obj.value = valr;}
            // } else {
            obj.value = valr;
            //}
          }
          if (objet=="SignUser") {
            var valr = document.getElementsByName(objet)[0].value;
            var obj  = document.getElementById("User");
            obj.value = valr;
          }
        }
    </script>
  </body>
</html>';
?>
