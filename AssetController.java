@RestController
@RequestMapping("/Assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping
    public ResponseEntity<String> createAsset(@RequestBody Asset asset) {
        String assetId = assetService.createAsset(asset);
        return ResponseEntity.created(URI.create("/assets/" + assetId)).body(assetId);
    }

    // Additional endpoints for updating, querying, and fetching asset history
}
