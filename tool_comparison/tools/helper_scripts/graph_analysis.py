import json

import networkx
import networkx as nx


def load_dfd(file_path: str) -> networkx.DiGraph:
    with open(file_path, 'r') as f:
        data = json.load(f)
    data['nodes'] = data['services']
    return nx.node_link_graph(data, directed=True, multigraph=False,
                              source='sender', target='receiver',
                              link='information_flows', name='name')
