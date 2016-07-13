package de.androbin.mep.term;

import java.math.*;
import jdk.nashorn.internal.objects.annotations.*;

public final class Negation implements Term
{
	private Term term;
	
	public Negation( final Term term )
	{
		this.term = term;
	}
	
	@ Override
	public BigDecimal evaluate( final MathContext context )
	{
		return term.evaluate( context ).negate( context );
	}
	
	@ Getter
	public Term getTerm()
	{
		return term;
	}
	
	@ Setter
	public void setTerm( final Term term )
	{
		this.term = term;
	}
	
	@ Override
	public String toString( final MathContext context )
	{
		return "-(" + getTerm().toString( context ) + ")";
	}
}