package percobaan.percobaan;

public class MahasiswaModel {
        private String nim;
        private String nama;
        private String alamat;

        public MahasiswaModel(String nim, String nama, String alamat){
            this.nim = nim;
            this.nama = nama;
            this.alamat = alamat;
        }

        public MahasiswaModel(String nim, String nama) {
        }

        public String getNim(){
            return nim;
        }
        public String getNama(){
            return nama;
        }
        public String getAlamat(){
            return alamat;
        }
        public  void setNim (String nim){
            this.nim = nim;
        }
        public  void setNama (String nama){
            this.nama = nama;
        }
        public  void setAlamat (String alamat){
            this.alamat = alamat;
        }
    }

