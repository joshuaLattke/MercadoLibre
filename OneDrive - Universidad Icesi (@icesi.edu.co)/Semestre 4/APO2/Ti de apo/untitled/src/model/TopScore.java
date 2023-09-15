package model;


public class TopScore {
    private User rootScore;



    public void addScore(String name, int score) {
        addScore(name, score, rootScore);


    }
    private void addScore(String name, int score , User current){

        if (rootScore == null) {
            rootScore = current;
        }

        if(current.getScore()< score){
            if(current.getLeft() == null){
                User user = new User(score, name);
                current.setLeft((user));
            }else{
                addScore(name, score, current.getLeft());
            }


        if(current.getScore()> score){
            // meter a la derecha
            if (current.getRigth() == null){
                User user = new User(score, name);
                current.setRight(user);
            }else{
                addScore(name, score, current.getRigth());
            }
        }
        }else {
            //No hacer nada (si son iguales)
            return;
        }
    }
        public User getRootScore() {
            return rootScore;
        }

        public void top(){
            top(rootScore);
        }

        private void top(User current){
            if (current== null){
                return;
            }
            top(current.getLeft());
            System.out.println(current.getScore() + " "+ current.getNickname());
            // Se va al subarbol de la derecha
            top(current.getRight());
        }
    }




