import FFSSM.Club;
import FFSSM.GroupeSanguin;
import FFSSM.Moniteur;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testMoniteur {
    Moniteur president, moniteur;
    Club club, club1;

    @BeforeEach
    public void setUp() throws Exception{
        moniteur = new Moniteur("adel", "Rezouki", "Zara", "Rabat", "06 14 60 30 30", LocalDate.of(1950, 2,2),2,1, GroupeSanguin.BPLUS);
        president = new Moniteur("Pull", "Acti", "Lamine", "Toulouse", "07 25 87 56 23", LocalDate.of(1999, 11,1),2,1, GroupeSanguin.APLUS);
    }
    @AfterEach
    public void tearDown() throws Exception{

    }
    @Test
    public void testNouvelleEmbauche(){
        assertTrue(moniteur.employeurActuel().isEmpty());
        moniteur.nouvelleEmbauche(club, LocalDate.of(2021,12,7));
        assertEquals(moniteur.employeurActuel().orElseThrow(), club1);
    }

    public void testTerminerEmbauche(){
        moniteur.nouvelleEmbauche(club, LocalDate.of(2022,12,13));
        moniteur.terminerEmbauche(LocalDate.of(2023,12,13));
        assertTrue(moniteur.employeurActuel().isEmpty());
    }
}
