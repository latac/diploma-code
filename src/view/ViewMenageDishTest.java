package view;

import Elements.Dish;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ViewMenageDishTest {

    private Dish danie;
    private AncestorListener listener;
    private ViewMenageDish vmd;

    @BeforeEach
    void setUp() {
        danie = new Dish();
        listener = new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        };
        vmd = new ViewMenageDish();
    }

    @AfterEach
    void tearDown() {
        danie = null;
        listener = null;
        vmd = null;
    }

}