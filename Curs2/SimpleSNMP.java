import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class SimpleSNMP {

    public static void main(String[] args) throws Exception {
        Snmp snmp = new Snmp(new DefaultUdpTransportMapping());
        snmp.listen();

        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString("public"));
        target.setVersion(SnmpConstants.version2c);
        target.setAddress(GenericAddress.parse("udp:127.0.0.1/161"));
        target.setRetries(2);
        target.setTimeout(1000);

        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(".1.3.6.1.2.1.1.1.0")));
        pdu.setType(PDU.GET);

        ResponseEvent response = snmp.send(pdu, target);
        PDU responsePDU = response.getResponse();

        if (responsePDU != null) {
            int errorStatus = responsePDU.getErrorStatus();
            int errorIndex = responsePDU.getErrorIndex();
            String errorStatusText = responsePDU.getErrorStatusText();

            if (errorStatus == PDU.noError) {
                System.out.println("Response received successfully");
                VariableBinding vb = responsePDU.get(0);
                System.out.println(vb.getOid() + " = " + vb.getVariable());
            } else {
                System.out.println("Error: " + errorStatusText);
            }
        }
    }
}
