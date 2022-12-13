import FFSSM.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class testPlongee {
    Moniteur president, moniteur;
    Club club;
    Plongee plongee;
    Licence licence1, licence2;
    Plongeur plongeur1, plongeur2;


    @BeforeEach
    protected void setUp() throws Exception{
        club = new Club(president, "Lui", "Tls", "06 05 05 05 05");

        plongeur1 = new Plongeur("542", "Rezouki", "Rokaya", "Casablanca", "06 05 98 92 97", LocalDate.of(2002,5,23), 2, GroupeSanguin.APLUS);
        plongeur1.ajouterLicence("54", LocalDate.of(2022,5,5), club);
        plongeur2 = new Plongeur("542", "Rezouki", "Omar", "Casablanca", "06 61 61 76 30", LocalDate.of(2002,5,23), 2, GroupeSanguin.APLUS);
        plongeur1.ajouterLicence("54", LocalDate.of(2022,5,23), club);

    //    moniteur = new Moniteur("")
    }
    @Test
    public void testAjouterParticipant(){
        plongee.ajouteParticipant(plongeur1);
        plongee.ajouteParticipant(plongeur2);
        assertEquals(2, plongee.getPalanquee().size());
    }

    @Test
    public void testPlongeeEstConforme(){
       plongee.ajouteParticipant(plongeur2);
       assertTrue(plongee.estConforme());

       plongee.ajouteParticipant(plongeur1);
       assertFalse(plongee.estConforme());
    }
}
