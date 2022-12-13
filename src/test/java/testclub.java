import FFSSM.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testclub {
  Club lesPlongeursA, clubSansplongueur;
  Moniteur president, moniteur;
  Plongeur plongueurLValide1, plongueurLValide2, plongueurLNonValide;
  Plongee plongeeNonConforme, plongeeConforme;


  @BeforeEach
    protected  void setUp() throws Exception{
      president = new Moniteur("Pull", "Acti", "Lamine", "Toulouse", "07 25 87 56 23", LocalDate.of(1999, 11,1),2,1, GroupeSanguin.APLUS);

      clubSansplongueur = new Club(president, "club","fond", "0605021515" );
      lesPlongeursA = new Club(president, "club","fond", "0605542415" );

      moniteur = new Moniteur("adel", "Rezouki", "Zara", "Rabat", "06 14 60 30 30", LocalDate.of(1950, 2,2),2,1, GroupeSanguin.BPLUS);
      plongueurLValide1 = new Plongeur("543", "Rezouki", "Rokaya", "Casablanca", "06 05 98 92 97", LocalDate.of(2002,5,23), 2, GroupeSanguin.APLUS);
      plongueurLValide1.ajouterLicence("543", LocalDate.of(2020,5,3), lesPlongeursA);
      plongueurLValide2 = new Plongeur("542", "Rezouki", "Rokaya", "Casablanca", "06 05 98 92 97", LocalDate.of(2002,5,23), 2, GroupeSanguin.APLUS);
      plongueurLValide2.ajouterLicence("542", LocalDate.of(2020,5,3), lesPlongeursA);
      plongueurLNonValide =  new Plongeur("52", "Rezki", "Roaya", "Casa", "06 05 98 92 52", LocalDate.of(2002,5,23), 2, GroupeSanguin.APLUS);
      plongueurLNonValide.ajouterLicence("52", LocalDate.of(2020,5,3), lesPlongeursA);

      plongeeNonConforme = new Plongee(new Site("tanger", "lfhuodom"), moniteur, LocalDate.of(2021,2,14),100,1);
      plongeeNonConforme.ajouteParticipant(plongueurLValide1);
      plongeeNonConforme.ajouteParticipant(plongueurLNonValide);
      plongeeNonConforme = new Plongee(new Site("tanger", "lfhuodom"), moniteur, LocalDate.of(2021,2,14),100,1);
      plongeeNonConforme.ajouteParticipant(plongueurLValide1);
      plongeeNonConforme.ajouteParticipant(plongueurLNonValide);
      plongeeNonConforme.ajouteParticipant(plongueurLValide1);
      plongeeNonConforme.ajouteParticipant(plongueurLValide2);
  }

  @AfterEach
    protected  void tearDown(){
      lesPlongeursA = null;
      president = null;
      moniteur = null;
      plongeeNonConforme = null;
      plongueurLValide1 = null;
      plongeeConforme = null;
      plongueurLValide2 = null;
      plongueurLNonValide = null;
  }

  @Test
    public void testOrganiseplongee() {
      lesPlongeursA.organisePlongee(plongeeConforme);
      lesPlongeursA.organisePlongee(plongeeNonConforme);
      assertEquals(2, lesPlongeursA.getActivite().size());

  }

  @Test
    public  void testDelivreLicence(){
      clubSansplongueur.ajouterLicence(new Licence(plongueurLValide1, "542", LocalDate.of(2022,6,3), lesPlongeursA));
      assertEquals(clubSansplongueur.getLicence().size(),1);
      assertEquals(lesPlongeursA.getLicence().size(), 3);

  }
  @Test
    public void testPlongeeNonConforme(){
      lesPlongeursA.organisePlongee(plongeeConforme);
      lesPlongeursA.organisePlongee(plongeeNonConforme);
      assertEquals(lesPlongeursA.plongeesNonConformes().size(), 1);
  }

}
