package de.androbin.mep.term;

import java.math.*;

public final class Wrapper implements Term {
  private BigDecimal number;
  
  public Wrapper( final BigDecimal number ) {
    this.number = number;
  }
  
  @ Override
  public BigDecimal evaluate( final MathContext context ) {
    return getNumber();
  }
  
  public BigDecimal getNumber() {
    return number;
  }
  
  public void setNumber( final BigDecimal number ) {
    this.number = number;
  }
  
  @ Override
  public String toString( final MathContext context ) {
    return number.signum() >= 0 ? number.toString() : "(" + number.toString() + ")";
  }
}