package de.androbin.mep.term;

import java.math.*;
import jdk.nashorn.internal.objects.annotations.*;

public final class Wrapper implements Term
{
	private BigDecimal number;
	
	public Wrapper( final BigDecimal number )
	{
		this.number = number;
	}
	
	@ Override
	public BigDecimal evaluate( final MathContext context )
	{
		return getNumber();
	}
	
	@ Getter
	public BigDecimal getNumber()
	{
		return number;
	}
	
	@ Setter
	public void setNumber( final BigDecimal number )
	{
		this.number = number;
	}
	
	@ Override
	public String toString( final MathContext context )
	{
		return number.signum() >= 0 ? number.toString() : "(" + number.toString() + ")";
	}
}