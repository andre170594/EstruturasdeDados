package testemoodle2;

public class JogoFutebol {

        String eqCasa;
        String eqVisi;
        int assist;

        public JogoFutebol(String eqCasa, String eqVisi, int assist) {
            this.eqCasa = eqCasa;
            this.eqVisi = eqVisi;
            this.assist = assist;
        }

        //gets
        public String getEqCasa() { return eqCasa; }
        public int getAssist() { return assist; }
        public String getEqVisi() { return eqVisi; }
        //sets
        public void setEqCasa(String eqCasa) { this.eqCasa = eqCasa; }
        public void setEqVisi(String eqVisi) { this.eqVisi = eqVisi; }
        public void setAssist(int assist) { this.assist = assist; }

}
