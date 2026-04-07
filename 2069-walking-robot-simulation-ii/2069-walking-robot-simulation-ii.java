class Robot {
    int width;
    int height;
    int currX;
    int currY;
    int currDir;
    long perimeter;
    long steps;
    public Robot(int width, int height) {
        this.height = height-1;
        this.width = width-1;
        this.currX = 0;
        this.currY = 0;
        this.currDir = 0;
        this.perimeter = 2*(this.height + this.width);
        this.steps = 0;
    }

    public void step(int num) {
//        num %= perimeter;
//        while (num > 0){
//            checkDir();
//            switch (currDir){
//                case 0:
////                    System.out.println("Moved EAST");
//                    this.currX++;
//                    break;
//                case 1:
////                    System.out.println("Moved North");
//                    this.currY++;
//                    break;
//                case 2:
////                    System.out.println("Moved West");
//                    this.currX--;
//                    break;
//                case 3:
////                    System.out.println("Moved South");
//                    this.currY--;
//                    break;
//            }
////            System.out.println("After Moving position: [" + this.currX +"," + this.currY + "]");
//            num--;
//        }
//        System.out.println("Steps completed position: [" + this.currX +"," + this.currY + "] and facing direction " + getDir());

        this.steps += num;
        this.steps = this.steps % perimeter;
        if(this.steps == 0 && this.currX == 0 && this.currY == 0){
            this.currDir = 3;
        }
    }

    private void checkDir() {
//        System.out.println("Size is: [" + this.width +"," + this.height + "]");
        switch (currDir){
            case 0:
                if(this.currX >= this.width)
                    updateDir();
                break;
            case 1:
                if(this.currY >= this.height)
                    updateDir();
                break;
            case 2:
                if(this.currX <= 0)
                    updateDir();
                break;
            case 3:
                if(this.currY <= 0)
                    updateDir();
                break;
        }
    }

    private void updateDir() {
        this.currDir = (this.currDir+1)%4;
//        System.out.println("Direction updated to " + getDir());
    }

    public int[] getPos() {
        processSteps();
        return new int[]{this.currX, this.currY};
    }

    public String getDir() {
        processSteps();
        switch (currDir){
            case 0:
                return "East";
            case 1:
                return "North";
            case 2:
                return "West";
            case 3:
                return "South";
            default:
                return "";
        }
    }
    
    private void processSteps(){
        while (this.steps> 0){
            checkDir();
            switch (currDir){
                case 0:
//                    System.out.println("Moved EAST");
                    this.currX++;
                    break;
                case 1:
//                    System.out.println("Moved North");
                    this.currY++;
                    break;
                case 2:
//                    System.out.println("Moved West");
                    this.currX--;
                    break;
                case 3:
//                    System.out.println("Moved South");
                    this.currY--;
                    break;
            }
//            System.out.println("After Moving position: [" + this.currX +"," + this.currY + "]");
            this.steps--;
        }
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */