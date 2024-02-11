import os, sys
current = os.path.dirname(os.path.realpath(__file__))
parent = os.path.dirname(current)
sys.path.insert(1, f"/{parent}/")
from src_utility import utility as src_utls

def add_parent_paths(levels):
    current = os.path.dirname(os.path.realpath(__file__))
    for _ in range(levels):
        current = os.path.dirname(current)
        sys.path.insert(1, f"{current}")
# Add two parent paths to sys.path
add_parent_paths(3)

from common import utility as utls