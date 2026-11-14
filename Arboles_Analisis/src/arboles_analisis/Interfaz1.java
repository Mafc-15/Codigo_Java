package arboles_analisis; 

public class Interfaz1 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Interfaz1.class.getName());
    private Nodo raiz;

  
  public Interfaz1() {
    initComponents();

    txtResultado.setText("");
    txtResultado.setEditable(false);

    jPanel1.setPreferredSize(new java.awt.Dimension(500, 300));
    jPanel1.setMinimumSize(new java.awt.Dimension(500, 300));

    jPanel1.setBackground(java.awt.Color.WHITE);
    jPanel1.setOpaque(true);

    pack();
    setLocationRelativeTo(null);
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtExpresion = new javax.swing.JTextField();
        BtnCalcular = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtResultado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Calculadora");

        jLabel2.setText("Ejemplo: (5+3)*2");

        jLabel3.setText("Ingresa una expresión algebraica:");

        BtnCalcular.setText("CALCULAR");
        BtnCalcular.addActionListener(this::BtnCalcularActionPerformed);

        jLabel4.setText("Resultado:");

        txtResultado.setText("jTextField2");

        jLabel5.setText("Arbol:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnCalcular)
                                .addGap(182, 182, 182))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                        .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(375, 375, 375))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExpresion, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(BtnCalcular)
                    .addComponent(txtExpresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCalcularActionPerformed
    try {
        String expresion = txtExpresion.getText().trim();
        if (expresion.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,"Ingresa una expresion");
            return;
        }
       double resultado = calcular(expresion);
Nodo raiz = construirArbol(expresion);
dibujarArbol(raiz);
txtResultado.setText(String.valueOf(resultado));
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this,"Error: " + e.getMessage());
        txtResultado.setText("");
    }
    }//GEN-LAST:event_BtnCalcularActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Interfaz1().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCalcular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtExpresion;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables
public double calcular(String expresion) {
    return new Object() {
        int posicion = -1;
        int caracter;
        void siguiente() {
            posicion++;
            caracter = posicion < expresion.length()
                    ? expresion.charAt(posicion) : -1;
        }
        void espacios() {
            while (caracter != -1 && Character.isWhitespace(caracter)) {
                siguiente();
            }
        }
        boolean aceptar(int esperado) {
            espacios();
            if (caracter == esperado) {
                siguiente();
                return true;
            }
            return false;
        }
        double resultado() {
            siguiente();
            double valor = expresion();
            espacios();
            if (caracter != -1) {
                throw new RuntimeException("Expresion incorrecta");
            }
            return valor;
        }
        double expresion() {
            double x = termino();
            while (true) {
                if (aceptar('+')) {
                    x += termino();
                } else if (aceptar('-')) {
                    x -= termino();
                } else {
                    return x;
                }
            }
        }
        double termino() {
            double x = factor();
            while (true) {
                if (aceptar('*')) {
                    x *= factor();
                } else if (aceptar('/')) {
                    double divisor = factor();
                    if (divisor == 0) {
                        throw new ArithmeticException("No se puede dividir entre cero");
                    }
                    x /= divisor;
                } else {
                    return x;
                }
            }
        }
        double factor() {
            if (aceptar('+')) return factor();
            if (aceptar('-')) return -factor();
            double x;
            int inicio = posicion;
            if (aceptar('(')) {
                x = expresion();
                if (!aceptar(')')) {
                    throw new RuntimeException("Falta cerrar parentesis");
                }
            } else if ((caracter >= '0' && caracter <= '9')
                    || caracter == '.') {
                while ((caracter >= '0' && caracter <= '9')
                        || caracter == '.') {
                    siguiente();
                }
                x = Double.parseDouble(
                        expresion.substring(inicio, posicion));
            } else {
                throw new RuntimeException("Expresion incorrecta");
            }
            return x;
        }
    }.resultado();
}


public Nodo construirArbol(String expresion) {
    return new ParserArbol(expresion).crear();
}

class ParserArbol {

    String expresion;
    int posicion = 0;

    public ParserArbol(String expresion) {
        this.expresion = expresion.replace(" ", "");
    }

    char actual() {
        if (posicion >= expresion.length()) {
            return '\0';
        }
        return expresion.charAt(posicion);
    }

    boolean aceptar(char signo) {
        if (actual() == signo) {
            posicion++;
            return true;
        }
        return false;
    }

    Nodo crear() {
        Nodo raiz = expresion();

        if (posicion != expresion.length()) {
            throw new RuntimeException("Expresion incorrecta");
        }

        return raiz;
    }

    Nodo expresion() {
        Nodo izquierda = termino();

        while (actual() == '+' || actual() == '-') {
            char signo = actual();
            posicion++;

            Nodo derecha = termino();
            Nodo nuevo = new Nodo(String.valueOf(signo));

            nuevo.izquierda = izquierda;
            nuevo.derecha = derecha;
            izquierda = nuevo;
        }

        return izquierda;
    }

    Nodo termino() {
        Nodo izquierda = factor();

        while (actual() == '*' || actual() == '/') {
            char signo = actual();
            posicion++;

            Nodo derecha = factor();
            Nodo nuevo = new Nodo(String.valueOf(signo));

            nuevo.izquierda = izquierda;
            nuevo.derecha = derecha;
            izquierda = nuevo;
        }

        return izquierda;
    }

    Nodo factor() {
        if (aceptar('(')) {
            Nodo nodo = expresion();

            if (!aceptar(')')) {
                throw new RuntimeException("Falta cerrar parentesis");
            }

            return nodo;
        }

        if (actual() == '-') {
            posicion++;
            Nodo nuevo = new Nodo("-");
            nuevo.izquierda = new Nodo("0");
            nuevo.derecha = factor();
            return nuevo;
        }

        int inicio = posicion;

        while (Character.isDigit(actual()) || actual() == '.') {
            posicion++;
        }

        if (inicio == posicion) {
            throw new RuntimeException("Numero incorrecto");
        }

        String numero = expresion.substring(inicio, posicion);
        Double.parseDouble(numero);

        return new Nodo(numero);
    }
}

public void dibujarArbol(Nodo raiz) {
 jPanel1.removeAll();
jPanel1.setLayout(null);
    jPanel1.setOpaque(true);
jPanel1.setBackground(java.awt.Color.WHITE);
jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK));
jPanel1.setLayout(null);
    

    if (raiz == null) {
        return;
    }

    int ancho = jPanel1.getWidth();

    if (ancho <= 0) {
        ancho = 500;
    }

    dibujarNodos(raiz, ancho / 2, 20, ancho / 4);

    jPanel1.revalidate();
    jPanel1.repaint();
}

private void dibujarNodos(Nodo nodo, int x, int y, int separacion) {

    javax.swing.JLabel etiqueta =
            new javax.swing.JLabel(nodo.valor);

    etiqueta.setHorizontalAlignment(
            javax.swing.SwingConstants.CENTER);

    etiqueta.setBounds(x - 20, y, 40, 25);
    jPanel1.add(etiqueta);

    if (nodo.izquierda != null) {

        javax.swing.JLabel linea =
                new javax.swing.JLabel("/");

        linea.setBounds(x - separacion / 2, y + 25, 20, 25);
        jPanel1.add(linea);

        dibujarNodos(nodo.izquierda,
                x - separacion, y + 65,
                Math.max(20, separacion / 2));
    }

    if (nodo.derecha != null) {

        javax.swing.JLabel linea =
                new javax.swing.JLabel("\\");

        linea.setBounds(x + separacion / 2, y + 25, 20, 25);
        jPanel1.add(linea);

        dibujarNodos(nodo.derecha,
                x + separacion, y + 65,
                Math.max(20, separacion / 2));
    }
}

}
