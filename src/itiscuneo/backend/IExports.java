package itiscuneo.backend;

public interface IExports {
    public final String PATH = "data/";
    public final String NAME_CSV = "cespite.csv";
    public final String NAME_JSON = "cespite.json";

    public void scriviCsv(ElencoCespiti elencoCespiti);
    public void scriviJson(ElencoCespiti elencoCespiti);
}
