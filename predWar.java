//Bell Wireless Technology Products Coding Challenge
//Tianhan (Amy) Fan

String my_player (int x, int y, int z, int r, float b){
  /*
   * for the first 2500 rounds
   * start by cooperating to build trust
   */
  if (r == 2500){
    return "cooperate";
  /*
   * considering most people will likely also cooperate at the beginning
   * take advantage of this by betraying for a short period
   * this will avoid too much predictability for future rounds
   */
  } else if (r <= 3000){
    return "betray";

  /*
   * assuming the previous player's tendencies (as determined by b) still carries to these rounds
   * at this point, other players might start to betray based on the opponent's b
   * if the risk is low for cooperating (ie. the difference between z and y is low), then cooperate to build trust
   * since I still want to build trust, I will cooperate with any opponents that have a history of cooperating
   */
  } else if (r <= 5000){
    if (b <= 0.3){
      return "cooperate";
    }else{
      if ((z - y) < 3){
        return "cooperate";
      } else{
        return "betray";
      }
    }
  /*
   * assuming opponents will start to betray more readily at this point
   * if the opponent has a high b, continue to betray assuming they will continue to do so
   * if the opponent as low b, only betray if the reward is high (ie. z - y > 1) to consider the chances that the opponent continues to cooperate
   */
  } else if (r <= 7500){
    if (b < 0.3){
      if ((z - y) < 2){
        return "cooperate";
      } else{
        return "betray";
      }
    } else{
      return "betray";
    }
  /*
   * at this point people will likely start to betray since it's most optimal
   * the best outcome in this case comes with always betraying
   */
  }else {
    return "betray";
  }
}
