import FFSSM.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testLicence {
    Moniteur president;
    Club club;
    Plongeur plongeur;
    Licence licenceValide, licenceNonValide;

    @BeforeEach
    protected  void setUp() throws Exception {


        president = new Moniteur("adel", "Rezouki", "Zara", "Rabat", "06 14 60 30 30", LocalDate.of(1950, 2, 2), 2, 1, GroupeSanguin.BPLUS);
        club = new Club(president, "Lui", "Tls", "06 05 05 05 05");
        plongeur = new Plongeur("Pull", "Acti", "Lamine", "Toulouse", "07 25 87 56 23", LocalDate.of(1999, 11, 1), 2,  GroupeSanguin.APLUS);
        licenceValide = new Licence(plongeur, "54", LocalDate.of(2022,5,5), club);
        licenceNonValide = new Licence(plongeur, "54", LocalDate.of(2020,5,5), club);
    }
    @Test
    public void testLicencevalide(){
        assertFalse(licenceNonValide.estValide(LocalDate.of(2020,6,6)));
        assertTrue(licenceValide.estValide(LocalDate.of(2020,6,6)));

    }
}
