package de.androbin.mep.term;

import java.math.*;

public final class Negation implements Term {
  private Term term;
  
  public Negation( final Term term ) {
    this.term = term;
  }
  
  @ Override
  public BigDecimal evaluate( final MathContext context ) {
    return term.evaluate( context ).negate( context );
  }
  
  public Term getTerm() {
    return term;
  }
  
  public void setTerm( final Term term ) {
    this.term = term;
  }
  
  @ Override
  public String toString( final MathContext context ) {
    return "-(" + getTerm().toString( context ) + ")";
  }
}