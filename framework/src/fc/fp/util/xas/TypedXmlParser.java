package fc.fp.util.xas;

import org.xmlpull.v1.XmlPullParser;

/**
 * An extended interface to permit parsing of typed XML content.
 * Typically when using typed content an application would perform the
 * decoding itself from the string given as element content.  However,
 * in the presence of serialization formats that do not map directly
 * to the event stream model of XmlPull this application-level
 * decoding might incur a performance penalty.  Therefore this
 * extended interface provides for ways to decode typed element
 * content already in the parsing stage.
 */
public interface TypedXmlParser extends XmlPullParser {

    /**
     * Typed content was just read.  This indicates that the character
     * data that was just read was typed according to XML Schema and
     * that the parser knows how to decode it.  The decoded form of
     * the read data is available through the new {@link #getObject}
     * method.  The namespace and local name of the type are available
     * through the {@link #getNamespace()} and {@link #getName}
     * methods.  A parser is not required to generate this event type
     * even if the parsed document is typed.
     */
    int OBJECT = 15;

    /**
     * Returns the typed content of the current event.  If the current
     * event type is {@link #OBJECT}, this returns the decoded form of
     * the object, otherwise this behaves like {@link #getText}.
     *
     * @return the decoded typed content of the current event
     */
    Object getObject ();

}
// arch-tag: 3aec3fc78dff2ea93c854e3a6b48e610 *-
