import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.shim.ChaincodeBase;
import org.hyperledger.fabric.shim.ChaincodeStub;
import org.hyperledger.fabric.shim.ledger.KeyValue;

public class AssetContract extends ChaincodeBase {

    private static final String ASSET_PREFIX = "asset";

    @Override
    public Response invoke(ChaincodeStub stub) {
        String function = stub.getFunctionAndParameters()[0];
        String[] args = stub.getFunctionAndParameters();

        switch (function) {
            case "CreateAsset":
                return createAsset(stub, args);
            case "UpdateAsset":
                return updateAsset(stub, args);
            case "QueryAsset":
                return queryAsset(stub, args);
            case "GetAssetHistory":
                return getAssetHistory(stub, args);
            default:
                return new ChaincodeResponse(ChaincodeStatus.UNKNOWN, "Unsupported function".getBytes());
        }
    }

    private ChaincodeResponse createAsset(ChaincodeStub stub, String[] args) {
        // Validation of input parameters would go here

        Asset asset = new Asset();
      
        // Set asset properties using args

        String assetId = ASSET_PREFIX + UUID.randomUUID().toString();
        stub.putState(assetId, asset.toBytes());
        return ChaincodeResponse.newSuccess(assetId.getBytes());
    }

    private ChaincodeResponse updateAsset(ChaincodeStub stub, String[] args) {
    if (args.length != 2) {
        return ChaincodeResponse.newError("Invalid number of arguments");
    }

    String assetId = args[0];
    byte[] assetBytes = stub.getState(assetId);

    if (assetBytes == null || assetBytes.length == 0) {
        return ChaincodeResponse.newError("Asset not found");
    }

    Asset asset = Asset.fromBytes(assetBytes);
    // Update asset properties with args[1] data

    stub.putState(assetId, asset.toBytes());
    return ChaincodeResponse.newSuccess("Asset updated successfully".getBytes());
}

    private ChaincodeResponse queryAsset(ChaincodeStub stub, String[] args) {
    if (args.length != 1) {
        return ChaincodeResponse.newError("Invalid number of arguments");
    }

    String assetId = args[0];
    byte[] assetBytes = stub.getState(assetId);

    if (assetBytes == null || assetBytes.length == 0) {
        return ChaincodeResponse.newError("Asset not found");
    }

    return ChaincodeResponse.newSuccess(assetBytes);
}

    private ChaincodeResponse getAssetHistory(ChaincodeStub stub, String[] args) {
    if (args.length != 1) {
        return ChaincodeResponse.newError("Invalid number of arguments");
    }

    String assetId = args[0];
    List<String> history = new ArrayList<>();

    QueryResultsIterator<KeyModification> results = stub.getHistoryForKey(assetId);
    for (KeyModification modification : results) {
        history.add(new String(modification.getValue()));
    }

    return ChaincodeResponse.newSuccess(history.toString().getBytes());
}


    
}
