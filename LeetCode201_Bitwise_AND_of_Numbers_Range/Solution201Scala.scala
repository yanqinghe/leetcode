object Solution201Scala {
  def rangeBitwiseAnd(m: Int, n: Int): Int = {

    var res = 0;

    if(m!=0){
      var mc = m;
      var nc = n;
      var facotr = 1;
      while ( mc!=nc) {
        facotr<<=1;
        nc>>=1;
        mc>>=1;
      }
      res = mc*facotr;
    }
    res
  }
}