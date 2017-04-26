package de.androbin.mep.term;

import java.math.*;
import java.util.*;

public final class Variable implements Term
{
	private static final Map<String, BigDecimal>	VALUES	= new HashMap<String, BigDecimal>();
	
	private final String							name;
	
	public Variable( final String name )
	{
		this( name, BigDecimal.ZERO );
	}
	
	public Variable( final String name, final BigDecimal value )
	{
		this.name = name.trim();
		set( this.name, value );
	}
	
	@ Override
	public BigDecimal evaluate( final MathContext context )
	{
		return VALUES.get( name );
	}
	
	public static BigDecimal get( final String name )
	{
		return VALUES.getOrDefault( name.toLowerCase(), BigDecimal.ZERO );
	}
	
	public String getName()
	{
		return name;
	}
	
	public static void set( final String name, final BigDecimal value )
	{
		VALUES.put( name.toLowerCase(), value );
	}
	
	@ Override
	public String toString( final MathContext context )
	{
		final BigDecimal number = evaluate( context );
		return number.signum() >= 0 ? number.toString() : "(" + number.toString() + ")";
	}
}