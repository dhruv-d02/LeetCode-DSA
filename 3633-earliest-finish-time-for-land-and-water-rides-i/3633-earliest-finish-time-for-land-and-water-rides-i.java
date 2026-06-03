class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minTime = Integer.MAX_VALUE;
        for(int i=0; i<landStartTime.length; i++){
            int landtime = landStartTime[i] + landDuration[i];
            for (int j = 0; j < waterStartTime.length; j++) {
                int waterTime = 0;
                if(waterStartTime[j] > landtime){
                    waterTime += waterStartTime[j] - landtime;
                }
                waterTime += waterDuration[j];
                minTime = Math.min(landtime+waterTime, minTime);
            }
        }

        for(int i=0; i<waterStartTime.length; i++){
            int watertime = waterStartTime[i] + waterDuration[i];
            for (int j = 0; j < landStartTime.length; j++) {
                int landTime = 0;
                if(landStartTime[j] > watertime){
                    landTime += landStartTime[j] - watertime;
                }
                landTime += landDuration[j];
                minTime = Math.min(watertime+landTime, minTime);
            }
        }
        return minTime;
    }
}