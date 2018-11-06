/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Presentacion.Inicio;
import javax.swing.JFrame;
import javax.swing.UIManager;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Alejandro Medina Jimenez
 * 
 **/
public class PracticaIPO {

    public static void main(String[] args) {
        // TODO code application logic here
        
        MenuPrincipal();
        
    }
    
    private static void MenuPrincipal() { 
       try{
           JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
           SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistAquaSkin"); // Setencia que aplica el skin Creme de Substance
           
           SubstanceLookAndFeel.setCurrentTheme( "org.jvnet.substance.theme.SubstanceAquaTheme" ); // Se aplica el tema Aqui de Substance
           SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermar");//Ejemplo de aplicacion de un watermark de Substance
       } catch (Exception e){
           e.printStackTrace();
       }
       
       Inicio s = new Inicio();
       s.setVisible(true);
    }
    
}

/*

    LISTA DE SKINS

– org.jvnet.substance.skin.AutumnSkin
– org.jvnet.substance.skin.BusinessBlackSteelSkin
– org.jvnet.substance.skin.BusinessBlueSteelSkin
– org.jvnet.substance.skin.BusinessSkin
– org.jvnet.substance.skin.CremeCoffeeSkin
– org.jvnet.substance.skin.CremeSkin
– org.jvnet.substance.skin.EmeraldDuskSkin
– org.jvnet.substance.skin.FieldOfWheatSkin
– org.jvnet.substance.skin.FindingNemoSkin
– org.jvnet.substance.skin.GreenMagicSkin
– org.jvnet.substance.skin.MagmaSkin
– org.jvnet.substance.skin.MangoSkin
– org.jvnet.substance.skin.MistAquaSkin
– org.jvnet.substance.skin.ModerateSkin
– org.jvnet.substance.skin.NebulaBrickWallSkin
– org.jvnet.substance.skin.NebulaSkin
– org.jvnet.substance.skin.OfficeBlue2007Skin
– org.jvnet.substance.skin.OfficeSilver2007Skin
– org.jvnet.substance.skin.RavenGraphiteGlassSkin
– org.jvnet.substance.skin.RavenGraphiteSkin
– org.jvnet.substance.skin.RavenSkin
– org.jvnet.substance.skin.SaharaSkin


LISTA DE TEMAS

– org.jvnet.substance.theme.SubstanceAquaTheme
– org.jvnet.substance.theme.SubstanceBarbyPinkTheme
– org.jvnet.substance.theme.SubstanceBottleGreenTheme
– org.jvnet.substance.theme.SubstanceBrownTheme
– org.jvnet.substance.theme.SubstanceCharcoalTheme
– org.jvnet.substance.theme.SubstanceCremeTheme
– org.jvnet.substance.theme.SubstanceDarkVioletTheme
– org.jvnet.substance.theme.SubstanceDesertSandTheme
– org.jvnet.substance.theme.SubstanceEbonyTheme
– org.jvnet.substance.theme.SubstanceJadeForestTheme
– org.jvnet.substance.theme.SubstanceLightAquaTheme
– org.jvnet.substance.theme.SubstanceLimeGreenTheme
– org.jvnet.substance.theme.SubstanceNegatedTheme
– org.jvnet.substance.theme.SubstanceOliveTheme
– org.jvnet.substance.theme.SubstanceOrangeTheme
– org.jvnet.substance.theme.SubstancePurpleTheme
– org.jvnet.substance.theme.SubstanceRaspberryTheme
– org.jvnet.substance.theme.SubstanceSaturatedTheme
– org.jvnet.substance.theme.SubstanceSepiaTheme
– org.jvnet.substance.theme.SubstanceSteelBlueTheme
– org.jvnet.substance.theme.SubstanceSunGlareTheme
– org.jvnet.substance.theme.SubstanceSunsetTheme
– org.jvnet.substance.theme.SubstanceTerracottaTheme

La lista de Watermarks de Substance 4.3 es:

– org.jvnet.substance.watermark. SubstanceBubblesWatermark
– org.jvnet.substance.watermark. SubstanceBinaryWatermark
– org.jvnet.substance.watermark. SubstanceCopperplateEngravingWatermark
– org.jvnet.substance.watermark. SubstanceCrosshatchWatermark
– org.jvnet.substance.watermark. SubstanceFabricWatermark
– org.jvnet.substance.watermark. SubstanceGenericNoiseWatermark
– org.jvnet.substance.watermark. SubstanceImageWatermark
– org.jvnet.substance.watermark. SubstanceKatakanaWatermark
– org.jvnet.substance.watermark.SubstanceLatchWatermark
– org.jvnet.substance.watermark. SubstanceMagneticFieldWatermark
– org.jvnet.substance.watermark. SubstanceMarbleVeinWatermark
– org.jvnet.substance.watermark.SubstanceMazeWatermark
– org.jvnet.substance.watermark. SubstanceMetalWallWatermark
– org.jvnet.substance.watermark.SubstanceNoneWatermark
– org.jvnet.substance.watermark.SubstanceNullWatermark
– org.jvnet.substance.watermark. SubstancePlanktonWatermark
– org.jvnet.substance.watermark. SubstanceStripeWatermark
– org.jvnet.substance.watermark. SubstanceWoodWatermark

4.1 Watermak de imagen
Una función interesante es  proporcionar una imagen propia para colocarlo de watermark en la aplicación; para esto utilizaremos el SubstanceImageWatermark instaciándolo y proporcionando  la ruta de la imagen como parámetro.

SubstanceLookAndFeel.setCurrentWatermark( new SubstanceImageWatermark(“c:\\tuxx.jpg”));

4.1.1 Opacidad de la imagen
Substance también permite cambiar la opacidad de la imagen del watermark através de la función setImageWatermarkOpacity() al cual se debe pasar el valor en flotante entre 0 y 1, siendo 1 la opacidad nula.

SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.3));//valor aproximado de la opacidad por default de imageWatermark

5. Redondear los botones.
La propiedad de cliente BUTTON_SHAPER_PROPERTY de Substance permite cambiar  la clasica forma rectangular del boton a una  más redondeada que puede hacerlo resaltar más o hacerlo mas amigable, por ejemplo.  La implementación se realiza desde la clase del JFrame (en mi caso la clase Ventana) en el constructor . Se debe pasar un objeto Shape que es la forma que tomará el boton y la cual proporcionara Substance: StandardButtonShaper que es un Shape que da redondeo al botón.

this.jButton1.putClientProperty( SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());

6. Lado de abertura de un botón
Permite que un cualquier lado de un boton esté abierto, es decir, acotado en espacio y borde de lado seleccionado: botton,  left, up, right. La propiedad BUTTON_SIDE_PROPERTY acota el area de lado y BUTTON_OPEN_SIDE_PROPERTY elimina el borde de tal costado.

this.jButton1.putClientProperty( SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.LEFT); this.jButton1.putClientProperty( SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.LEFT);

*/