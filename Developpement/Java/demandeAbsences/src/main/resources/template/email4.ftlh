<div>
<!--HEADER-->

    <#include "/include/entete.ftl">

        <!--START OF BODY-->

        div style="padding: 15px 15px 30px 15px; font-family: Verdana, Arial, Helvetica, sans-serif; font-size:1em; background-color: #fff; color:#333;">
            <p>Bonjour</p>
            <p>
                L'employé(e) <span>${nom} </span>
                <span>${prenom}</span> dont vous êtes le ou la responsable, demande à bénéficier de
                <span>${typeConge}</span> du
                <span>${debutConge}</span> au
                <span>${finConge}</span>.<br>
            </p>
            <p>
                En qualité de Service Rh, merci de bien vouloir étudier la demande référencée sous le N°
                <span>${numDemande}</span> et d'y apporter votre validation ou votre refus en vous connectant à l'application<br>
            </p>
            <p>
                Nous attirons votre vigilance sur l'importance et votre engagement concernant votre validation ou votre refus.
            </p>
            <p>
                Cordialement,
            </p>
            <p>
                &emsp; <em>L'équipe de gestion des absences</em>
            </p>
            <p style="color:red; font-size: 0.6em">
                *Ce message vous a été envoyé automatiquement, merci de ne pas répondre.
            </p>
        </div>

<!--FOOTER-->
        
        <#include "/include/footer.ftl">
