package corbaContract.generated;

/**
* corbaContract/generated/MatchresultCorbaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from matchresult.idl
* Freitag, 16. November 2012 16:53 Uhr MEZ
*/

public final class MatchresultCorbaHolder implements org.omg.CORBA.portable.Streamable
{
  public corbaContract.generated.MatchresultCorba value = null;

  public MatchresultCorbaHolder ()
  {
  }

  public MatchresultCorbaHolder (corbaContract.generated.MatchresultCorba initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = corbaContract.generated.MatchresultCorbaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    corbaContract.generated.MatchresultCorbaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return corbaContract.generated.MatchresultCorbaHelper.type ();
  }

}
