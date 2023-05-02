package Pacman;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Pacman {

	private JFrame frame;
	public int pac_x=40,pac_y=30;
	public int speed=10;
	public int tamBocaPacman=300;
	public Element pacman = new Element(pac_x, pac_y, 30, 30,Color.yellow,tamBocaPacman);
	//public Element pared1 = new Element(5,20,290,10,Color.red);
	//public Element pared2 = new Element(5,20,290,10,Color.red);
	public Element paredes[]= new Element[29];
	public Element[][] cordComida = new Element[84][2];
	public int puntos=0;
	int tam;
	JPanel panel_1 = new JPanel();

	static int cantidadComida;
	//int xSalida1,ySalida1,xSalida2,ySalida2;
	//String direc;
	JLabel lblNewLabel = new JLabel("PUNTOS: ");
	
	Timer timer = new Timer();

	
	int o=0;
	// mapa de comida, 0=comida, 1=muro, 2=muro,
	String mapa[]= {
			"0","0","0","1","0","0","0","0","0","2","0","0",
			"0","1","0","0","1","0","2","2","2","0","2","0",
			"0","1","0","0","0","0","0","0","0","0","0","0",
			
			"0","1","0","1","2","0","2","2","2","2","0","0",
			"0","1","0","0","0","2","2","2","2","0","0","0",
			
			"0","1","0","0","0","2","2","2","2","0","0","1",
			"0","1","0","0","0","0","0","0","0","0","0","0",
			"0","1","0","0","0","2","2","2","2","0","0","0",
			"0","1","0","0","1","0","2","2","1","1","0","0",
			"0","1","0","0","0","0","0","0","0","2","0","0",
			
			
			
			};
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pacman window = new Pacman();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
	}
	
	TimerTask bocaPacman = new TimerTask() {
        public void run() {
          bocaPacman();
        }
	};
     

	/**
	 * Create the application.
	 */
	public Pacman() {
		ponerComida();
		initialize();
		pintarMapa();
		
		
	}
	int i=0;
	public void bocaPacman() {
		if(i==0) {
			pacman.tamBocaPacman=360;
		}
		if(i==2) {
			pacman.tamBocaPacman=310;
		}
		if(i==3) {
			pacman.tamBocaPacman=280;
		}
		if(i+1>3) {
			i=0;
		}else {
			i++;
		}
		panel_1.repaint();

		
		
	}
	
	/*public void moverPacman() {
		for(int i=0;i<paredes.length;i++) {
			if(pacman.tocando(paredes[i])) {
		    	//System.out.println("hola");
		    
				switch(direc) {
				case "arriba":
					pacman.y-=speed;
				break;
				case "abajo":
					pacman.y+=speed;
				break;
				case "derecha":
					pacman.x+=speed;
				break;
				case "izquierda":
					pacman.x-=speed;
				break;
				}
		    }
			
			
		}
	}*/
	public void ponerComida() {
		int x=40,y=30;
		int i2=0;
		
		for(int i=0;i<mapa.length;i++) {
			if(mapa[i]=="0") {
				
				
				cantidadComida++;
				cordComida[i2][0]= new Element(x,y, 20, 20,Color.decode("#7BFF8E"));
				cordComida[i2][1]=new Element(false);
				//System.out.println("X: "+x+"  Y: "+y);
				tam++;
				//System.out.println(x);
				i2++;
				x+=40;
				
				
			}else {
				
				if(mapa[i]=="2") {
					x+=35;
				}else {
					x+=10;
				}
				
			}
			o++;
			if(o==12) {
				o=0;
				y+=40;
				x=40;
			}

		}
		
		
		//System.out.println("ss"+cantidadComida);
		
	}
	public void pintarMapa() {
		//bordes
		paredes[0]= new Element(25,10,410,10,Color.blue);
		paredes[1]= new Element(465,10,175,10,Color.blue);
		paredes[28]= new Element(465,225,195,10,Color.blue);

		paredes[2]= new Element(25,10,10,450,Color.blue);
		paredes[3]= new Element(70,410,10,400,Color.blue);//2
		
		//vertical izquierda
		paredes[4]= new Element(150,10,100,10,Color.blue);
		paredes[5]= new Element(70,80,130,10,Color.blue);
		
		paredes[6]= new Element(70,260,130,10,Color.blue);
		paredes[7]= new Element(150,310,100,10,Color.blue);
		paredes[9]= new Element(70,80,130,10,Color.blue);
		paredes[10]= new Element(70,260,150,10,Color.blue);
		paredes[11]= new Element(150,310,100,10,Color.blue);


		//vertical Derecha
		paredes[8]= new Element(380,10,100,10,Color.blue);
		paredes[23]= new Element(380,310,100,10,Color.blue);

		
		
		
		
		//horizontal
		
		paredes[12]= new Element(220,70,10,100,Color.blue);
		paredes[13]= new Element(220,310,10,100,Color.blue);
		paredes[14]= new Element(220,360,10,100,Color.blue);
		
		paredes[24]= new Element(430,60,10,40,Color.blue);
		paredes[25]= new Element(430,350,10,40,Color.blue);
		
		paredes[26]= new Element(410,175,10,60,Color.blue);
		paredes[27]= new Element(410,225,10,60,Color.blue);
		
		
		//casita spawn enemigos
		paredes[15]= new Element(200,260,10,150,Color.blue);
		paredes[16]= new Element(200,140,120,10,Color.blue);
		paredes[17]= new Element(340,140,120,10,Color.blue);
		
		paredes[18]= new Element(200,140,10,60,Color.blue);
		paredes[19]= new Element(300,140,10,50,Color.blue);
		
		//cuadritos 

		paredes[20]= new Element(120,150,10,40,Color.blue);
		paredes[21]= new Element(120,210,10,40,Color.blue);
		paredes[22]= new Element(120,260,10,40,Color.blue);

		
		

		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		timer.schedule(bocaPacman, 0, 100);

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Reiniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				reiniciar();
				
				
			}
		});
		panel.add(btnNewButton);
		
		
		lblNewLabel.setBackground(new Color(0, 128, 64));
		lblNewLabel.setForeground(new Color(128, 0, 128));
		// lblNewLabel.setOpaque(true);
		panel.add(lblNewLabel);
		
		//panel_1 es el tablero
		panel_1.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		//llamada
		panel_1.add(new MyGraphics());
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
		
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				// TODO Auto-generated method stub
				//System.out.println(e.getKeyChar());
				if(e.getKeyCode()==87) {
					
					//direc="arriba";
					pacman.y-=speed;
					
				}
				if(e.getKeyCode()==83) {
					//direc="abajo";
					pacman.y+=speed;	
				}
				if(e.getKeyCode()==65) {
					//direc="izquierda";
					pacman.x-=speed;	
				}
				if(e.getKeyCode()==68) {
					//direc="derecha";
					pacman.x+=speed;	
				}
				
				for(int i=0;i<paredes.length;i++) {
					if(pacman.tocando(paredes[i])) {
		            	//System.out.println("hola");
		            	if(e.getKeyCode()==87) {
							pacman.y+=speed;
						}
		            	if(e.getKeyCode()==83) {
							pacman.y-=speed;	
						}
		            	
		            	if(e.getKeyCode()==65) {
							pacman.x+=speed;	
						}
		            	if(e.getKeyCode()==68) {
							pacman.x-=speed;	
						}
						
		            }
					
					
				}

				for(int i=0;i<tam;i++) {
					
						if(pacman.tocandoComida(cordComida[i][0])) {
							if(cordComida[i][1].comido==false) {
								cordComida[i][1].comido=true;
								puntos++;
								lblNewLabel.setText("  PUNTOS:  "+puntos);
								
								
								if(puntos==cantidadComida) {
									panel_1.repaint();
									JOptionPane.showMessageDialog(null,"Haz limpiado todo el mapa!!");
									reiniciar();
								}else {
									//System.out.println("aaa: "+puntos+"   c"+cantidadComida);
								}
								//System.out.println("Puntos: "+puntos);
							}
							

						}
	
				}
				
				//System.out.println("x: "+pacman.x+" y: "+pacman.y);
				//System.out.println("xs1: "+xSalida1+" ys1: "+ySalida1);
				//System.out.println("xs2: "+xSalida2+" ys2: "+ySalida2);
				if(pacman.x>=420 && pacman.y==190) {
					pacman.x=40;
					pacman.y=390;
					
					
				}else {
					if(pacman.x==40 && pacman.y>=390) {
						pacman.x=420;
						pacman.y=190;
						
					}
				}
				

				panel_1.repaint();
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		frame.setFocusable(true);
		frame.requestFocus();
		
		
	}
	
	public void reiniciar() {
		tam=0;
		cantidadComida=0;
		
		ponerComida();
		
		pacman.x=40;
		pacman.y=30;
		puntos=0;
		lblNewLabel.setText("   PUNTOS: "+puntos);
		
		frame.setFocusable(true);
		frame.requestFocus();
		frame.revalidate();
		frame.repaint();
	}
	
	//esdd
	 public class MyGraphics extends JComponent {

	        private static final long serialVersionUID = 1L;

	        MyGraphics() {
	            setPreferredSize(new Dimension(480, 420));
	        }

	        @Override
	        public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            //fondo
	            //g.fillRect(0,0, 480, 420);
	            //pacman
	            g.setColor(pacman.c);
	            g.fillArc(pacman.x, pacman.y, pacman.w, pacman.h, 0,pacman.tamBocaPacman);
	           
	            //pared
	            for(int i=0;i<paredes.length;i++) {
	            	 g.setColor(paredes[i].c);
	  	             g.fillRect(paredes[i].x, paredes[i].y, paredes[i].w, paredes[i].h);
	  	            
	  	            
	  	            
	            }
	            
	            //comidas
	            
	            for(int i=0;i<tam;i++) {
	            	if(cordComida[i][1].comido==false) {
	            		 g.setColor(cordComida[i][0].c);
	           
	 	 	            g.fillArc(cordComida[i][0].x,cordComida[i][0].y, cordComida[i][0].w, cordComida[i][0].h, 0,360);
	            	}
	            	
	            }
	            
	            
    
	       }
	        
	        
	        
	     
	    }
	 
	 
	 
	 public class Element {
		 int x,y,h,w,tamBocaPacman;
		 boolean comido;
		 Color c;
		 //pacman
		 Element(int x,int y,int h,int w,Color c,int tamBocaPacman){
			 this.x=x;
			 this.y=y;
			 this.h=h;
			 this.w=w;
			 this.c=c;
			 this.tamBocaPacman=tamBocaPacman;
			 
		 }
		 //paredes
		 Element(int x,int y,int h,int w,Color c){
			 this.x=x;
			 this.y=y;
			 this.h=h;
			 this.w=w;
			 this.c=c;
			 
			 
		 }
		 Element(boolean comido){
			 this.comido=comido;
			 
		 }
		 public boolean tocando(Element e) {
			 if(this.x<e.x+e.w && this.x + this.w >e.x && this.y<e.y + e.h &&  this.y + this.h > e.y ) {
				 return true;
			 }else {
				 return false;
			 }
						
		 }
		 
		 public boolean tocandoComida(Element e) {
			 if(this.x<e.x+e.w && this.x + this.w >e.x && this.y<e.y + e.h &&  this.y + this.h > e.y ) {
				 return true;
			 }else {
				 return false;
			 }
						
		 }
	 }

}