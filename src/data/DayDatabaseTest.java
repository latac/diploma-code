package data;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DayDatabaseTest {
    @Mock
    DayDatabase dayDB;
    @InjectMocks
    DataConnector dataConnector;

    @Test
    void usun() {
        dataConnector = DataConnector.Instance();
        dayDB = new DayDatabase(dataConnector);

        when(dayDB.Usun(1)).thenReturn(false);

        boolean result = dayDB.Usun(1);

        assertFalse(result);
    }

    @Test
    void edytuj() {
    }

    @Test
    void dodajPosilekDoDnia() {
    }

    @Test
    void usunPosilekZDnia() {
    }

    @Test
    void dodajSwieto() {
    }

    @Test
    void usunSwieto() {
    }

    @Test
    void ileSwiat() {
    }

    @Test
    void czyJestemSwietem() {
    }
}