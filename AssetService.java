@Service
public class AssetService {

    @Autowired
    private FabricClient fabricClient;

    public String createAsset(Asset asset) {
        // Interact with the blockchain and invoke 'CreateAsset'
        return fabricClient.invokeCreateAsset(asset);
    }

    public String updateAsset(String assetId, Asset asset) {
        // Interact with the blockchain and invoke 'UpdateAsset'
        return fabricClient.invokeUpdateAsset(assetId, asset);
    }

    public Asset queryAsset(String assetId) {
        // Interact with the blockchain and invoke 'QueryAsset'
        return fabricClient.invokeQueryAsset(assetId);
    }

    public List<String> getAssetHistory(String assetId) {
        // Interact with the blockchain and invoke 'GetAssetHistory'
        return fabricClient.invokeGetAssetHistory(assetId);
    }
}
