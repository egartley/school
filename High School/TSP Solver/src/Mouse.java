import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Mouse implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Field.onClick(e.getX(), e.getY());
        UI.onClick(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

}