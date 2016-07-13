package de.androbin.mep;

import static de.androbin.gfx.SystemGraphics.*;
import de.androbin.mep.term.*;
import java.math.*;
import javax.swing.*;

public final class Test
{
	private static final String		 TITLE	 = "Mathematical Expression Parser";
	private static final MathContext CONTEXT = MathContext.DECIMAL32;
											 
	private Test()
	{
	}
	
	public static void main( final String[] args )
	{
		setSystemLookAndFeel();
		setStandardConstants();
		
		while ( query( CONTEXT ) )
		{
		}
	}
	
	public static boolean query( final MathContext context )
	{
		final String expression = JOptionPane.showInputDialog( null, "Please enter expression:", TITLE, JOptionPane.PLAIN_MESSAGE );
		
		if ( expression == null || expression.trim().isEmpty() )
		{
			return false;
		}
		else
		{
			JOptionPane.showMessageDialog( null,
			        "The expression evaluates to '" + MEP.parseTerm( context, expression ).evaluate( context ).toString() + "'",
			        TITLE, JOptionPane.PLAIN_MESSAGE );
			return true;
		}
	}
	
	public static void setStandardConstants()
	{
		Variable.set( "pi", new BigDecimal( "3.141592653589793" ) );
		Variable.set( "e", new BigDecimal( "2.718281828459045" ) );
	}
}