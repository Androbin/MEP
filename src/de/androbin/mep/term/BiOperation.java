package de.androbin.mep.term;

import java.math.*;

public abstract class BiOperation implements Term {
  private Term first;
  private Term second;
  
  public BiOperation( final BigDecimal first, final BigDecimal second ) {
    this( new Wrapper( first ), new Wrapper( second ) );
  }
  
  public BiOperation( final Term first, final Term second ) {
    this.first = first;
    this.second = second;
  }
  
  @ Override
  public BigDecimal evaluate( final MathContext context ) {
    return evaluate( context, getFirst().evaluate( context ), getSecond().evaluate( context ) );
  }
  
  public abstract BigDecimal evaluate( final MathContext context, final BigDecimal first,
      final BigDecimal second );
  
  public Term getFirst() {
    return first;
  }
  
  public Term getSecond() {
    return second;
  }
  
  public void setFirst( final Term first ) {
    this.first = first;
  }
  
  public void setSecond( final Term second ) {
    this.second = second;
  }
  
  @ Override
  public String toString( final MathContext context ) {
    final int p = getToken().pre;
    
    final boolean p1 = getFirst().getToken().pre < p;
    final boolean p2 = getSecond().getToken().pre < p;
    
    final StringBuilder sb = new StringBuilder();
    
    if ( p1 ) {
      sb.append( '(' );
    }
    
    sb.append( getFirst().toString( context ) );
    
    if ( p1 ) {
      sb.append( ')' );
    }
    
    sb.append( getToken().op );
    
    if ( p2 ) {
      sb.append( '(' );
    }
    
    sb.append( getSecond().toString( context ) );
    
    if ( p2 ) {
      sb.append( ')' );
    }
    
    return sb.toString();
  }
}