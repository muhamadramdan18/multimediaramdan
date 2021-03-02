
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.applet.Applet;
/**
 *
 * @author Fitri
 */
public class gambar extends Applet{
Image picture1, picture2, picture3;
public void init() {
picture1 =getImage(getCodeBase(),"a.jpg");
picture2 = getImage(getCodeBase(),"b.jpg");
picture3 = getImage(getCodeBase(),"c.jpg");
}
    public void paint(Graphics g) {
g.drawImage(picture1, 0,0, this);
g.drawImage(picture2, 200,200, this);
g.drawImage(picture3, 400,400, this);
}
}
