package server.corba.generated;

/**
* corbaContract/generated/MatchresultListCorbaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from matchresult.idl
* Freitag, 16. November 2012 16:53 Uhr MEZ
*/

public final class MatchresultListCorbaHolder implements org.omg.CORBA.portable.Streamable
{
  public server.corba.generated.MatchresultListCorba value = null;

  public MatchresultListCorbaHolder ()
  {
  }

  public MatchresultListCorbaHolder (server.corba.generated.MatchresultListCorba initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = server.corba.generated.MatchresultListCorbaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
        server.corba.generated.MatchresultListCorbaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return server.corba.generated.MatchresultListCorbaHelper.type ();
  }

}